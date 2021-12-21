package com.kh.spring23.controller;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring23.dto.BuyDetailDto;
import com.kh.spring23.dto.BuyDto;
import com.kh.spring23.dto.ProductDto;
import com.kh.spring23.repository.BuyDao;
import com.kh.spring23.repository.BuyDetailDao;
import com.kh.spring23.repository.ProductDao;
import com.kh.spring23.service.KakaoPayService;
import com.kh.spring23.vo.KakaoPayApproveRequestVO;
import com.kh.spring23.vo.KakaoPayApproveResponseVO;
import com.kh.spring23.vo.KakaoPayReadyRequestVO;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private BuyDao buyDao;

	@Autowired
	private BuyDetailDao buyDetailDao;

	@GetMapping("/confirm")
	public String confirm() {
		return "pay/confirm";
	}
	
	//결제 준비 요청
	@PostMapping("/confirm")
	public String confirm(HttpSession session, @ModelAttribute KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		
		requestVO.setPartner_order_id(UUID.randomUUID().toString());
		requestVO.setPartner_user_id(UUID.randomUUID().toString());
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		//success에서 사용할 수 있도록 세션에 다음 데이터를 첨부
		//- partner_order_id
		//- partner_user_id
		//- tid
		session.setAttribute("partner_order_id", requestVO.getPartner_order_id());
		session.setAttribute("partner_user_id", requestVO.getPartner_user_id());
		session.setAttribute("tid", responseVO.getTid());
		
		return "redirect:"+responseVO.getNext_redirect_pc_url();
		
	}
	
	//카카오페이의 결제가 성공할 경우 다음과 같은 형태로 요청이 발생한다(카카오페이가 발생시키는 요청)
	//= 반드시 파라미터에 pg_token이 들어오며 이를 이용해서 승인 요청을 해야 한다
	//http://localhost:8080/spring23/pay/success?pg_token=459432df7ef421f46643
	@GetMapping("/success")
	public String success(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		//결제 승인 요청
		
		//세션에 전달되는 다음 데이터들을 수신한 뒤 삭제
		//- partner_order_id
		//- partner_user_id
		//- tid
		//- list(상품 상세 내역)
		String partner_order_id = (String) session.getAttribute("partner_order_id");
		String partner_user_id = (String) session.getAttribute("partner_user_id");
		String tid = (String) session.getAttribute("tid");
		List<ProductDto> list = (List<ProductDto>) session.getAttribute("list");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		session.removeAttribute("list");

		KakaoPayApproveRequestVO requestVO = new KakaoPayApproveRequestVO();
		requestVO.setTid(tid);
		requestVO.setPartner_order_id(partner_order_id);
		requestVO.setPartner_user_id(partner_user_id);
		requestVO.setPg_token(pg_token);
		
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		//결제가 완료된 시점 responseVO를 사용하여 buy 테이블에 insert를 수행
		BuyDto buyDto = new BuyDto();
		buyDto.setNo(Integer.parseInt(responseVO.getPartner_order_id()));
		buyDto.setTid(responseVO.getTid());
		buyDto.setItemName(responseVO.getItem_name());
		buyDto.setTotalAmount(responseVO.getAmount().getTotal());
		buyDao.insert(buyDto);//거래번호 생성

		//대표 결제정보가 등록된 다음 상세 결제정보를 등록(buy_detail)
		//= 상세 결제정보 데이터는 어디서?
		for(ProductDto productDto : list) {
			BuyDetailDto buyDetailDto = new BuyDetailDto();
			buyDetailDto.setBuyNo(buyDto.getNo());//결제번호
			buyDetailDto.setProductNo(productDto.getNo());//상품번호
			buyDetailDto.setProductName(productDto.getName());//상품이름
			buyDetailDto.setQuantity(1);//수량(1로 가정)
			buyDetailDto.setPrice(productDto.getPrice() * 1);//총금액 = 개당금액 * 수량

			buyDetailDao.insert(buyDetailDto);
		}

		return "redirect:success_result";
	}
	
	@GetMapping("/success_result")
	public String successResult() {
		return "pay/success_result";
	}
	
	@GetMapping("/confirm2")
	public String confirm2(@RequestParam List<Integer> no, Model model) {
		//no를 이용하여 상품명단을 조회하고 model에 추가
		List<ProductDto> list = productDao.search(no);
		model.addAttribute("list", list);
		return "pay/confirm2";
	}
	
	//사용자가 최종 결제할 상품 번호를 취합해서 여러 정보를 계산하고 결제 요청을 보낸다
	@PostMapping("/confirm2")
	public String confirm2(@RequestParam List<Integer> no, HttpSession session) throws URISyntaxException {
		//no를 이용하여 상품명단을 조회하고 model에 추가
		List<ProductDto> list = productDao.search(no);
		
		//이름 계산
		String item_name = list.get(0).getName();
		if(list.size() > 1) {
			item_name += " 외 "+(list.size()-1)+"건";
		}
		
		long total = 0L;
		for(ProductDto productDto : list) {
			total += productDto.getPrice();
		}
		
		//partner_order_id로 사용할 번호를 추출
		int sequence = buyDao.sequence();
		
		KakaoPayReadyRequestVO requestVO = new KakaoPayReadyRequestVO();
		//requestVO.setPartner_order_id(UUID.randomUUID().toString());//랜덤 방식의 주문번호
		requestVO.setPartner_order_id(String.valueOf(sequence));//데이터베이스 시퀀스 기반 주문번호
		requestVO.setPartner_user_id(UUID.randomUUID().toString());
		requestVO.setItem_name(item_name);
		requestVO.setQuantity(1);
		requestVO.setTotal_amount(total);
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		//success에서 사용할 수 있도록 세션에 다음 데이터를 첨부
		//- partner_order_id
		//- partner_user_id
		//- tid
		//- list(상품 상세 목록)
		session.setAttribute("partner_order_id", requestVO.getPartner_order_id());
		session.setAttribute("partner_user_id", requestVO.getPartner_user_id());
		session.setAttribute("tid", responseVO.getTid());
		session.setAttribute("list", list);

		return "redirect:"+responseVO.getNext_redirect_pc_url();
	}
}