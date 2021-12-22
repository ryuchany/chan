package com.kh.spring23.service;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring23.vo.KakaoPayApproveRequestVO;
import com.kh.spring23.vo.KakaoPayApproveResponseVO;
import com.kh.spring23.vo.KakaoPayCancelResponseVO;
import com.kh.spring23.vo.KakaoPayReadyRequestVO;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;
import com.kh.spring23.vo.KakaoPaySearchResponseVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class KakaoPayServiceImpl implements KakaoPayService{
	public static final String Authorization = "KakaoAK add70f3b7cf356da658c07a929a2dd55";
	public static final String ContentType = "application/x-www-form-urlencoded;charset=utf-8";
	
	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		//1. 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//2. 필요한 정보 추가(HTTP header, HTTP body)
		//2-1. HTTP Header 정보 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Authorization);
		headers.add("Content-type", ContentType);
		
		//2-2. HTTP Body 정보 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", requestVO.getPartner_order_id());//랜덤시리얼 --> 결제 테이블 시퀀스
		body.add("partner_user_id", requestVO.getPartner_user_id());//랜덤시리얼 --> 사용자 ID or 판매자 ID
		body.add("item_name", requestVO.getItem_name());
		body.add("quantity", requestVO.getQuantity_string());
		body.add("total_amount", requestVO.getTotal_amount_string());
		body.add("tax_free_amount", "0");
		
		//카카오서버에게 결제 결과에 따른 페이지를 미리 안내(단, 애플리케이션에 등록된 주소만 가능)
		//=(주의) 반드시 완성된 주소를 알려줘야 카카오에서 우리 서버로 다시 돌아올 수 있다
		body.add("approval_url", "http://localhost:8080/spring23/pay/success");
		body.add("cancel_url", "http://localhost:8080/spring23/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring23/pay/fail");
		
		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//4. 요청방식에 따라 다른 명령으로 전송
		//Map map = template.postForObject(uri, entity, Map.class);//응답을 기대하는 요청(JSON)
		//log.debug("map = {}", map);
		
		KakaoPayReadyResponseVO responseVO = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return responseVO;
	}
	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) throws URISyntaxException {
		//1. 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//2. 필요한 정보 추가(HTTP header, HTTP body)
		//2-1. HTTP Header 정보 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Authorization);
		headers.add("Content-type", ContentType);
		
		//2-2. HTTP Body 정보 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", requestVO.getTid());
		body.add("partner_order_id", requestVO.getPartner_order_id());
		body.add("partner_user_id", requestVO.getPartner_user_id());
		body.add("pg_token", requestVO.getPg_token());
		
		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//4. 요청방식에 따라 다른 명령으로 전송
		KakaoPayApproveResponseVO responseVO = template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);//응답을 기대하는 요청(JSON)
		log.debug("responseVO = {}", responseVO);
		
		return responseVO;
	}
	@Override
	public KakaoPaySearchResponseVO search(String tid) throws URISyntaxException {
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Authorization);
		headers.add("Content-type", ContentType);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", tid);
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		KakaoPaySearchResponseVO responseVO = template.postForObject(uri, entity, KakaoPaySearchResponseVO.class);
		return responseVO;
	}

	@Override
	public KakaoPayCancelResponseVO cancel(String tid, long amount) throws URISyntaxException {
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Authorization);
		headers.add("Content-type", ContentType);

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", tid);
		body.add("cancel_amount", String.valueOf(amount));
		body.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> entity = 
				new HttpEntity<MultiValueMap<String,String>>(body, headers);

		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");

		KakaoPayCancelResponseVO responseVO = template.postForObject(uri, entity, KakaoPayCancelResponseVO.class);

		return responseVO;
	}

}