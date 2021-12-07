package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring11.entity.ProductDto;
import com.kh.spring11.repository.ProductDao;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@GetMapping("/insert")//@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		//return "/WEB-INF/views/product/insert.jsp";//뷰리졸버 적용 전
		return "product/insert";//뷰리졸버 적용 후
	}

	@PostMapping("/insert")//@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute ProductDto productDto) {
		productDao.insert(productDto);
		return "redirect:/";
	}
	
//	목록 요청 처리
	@RequestMapping("/list")
	public String list(Model model) {
//		List<ProductDto> list = productDao.list();
//		model.addAttribute("list", list);
		model.addAttribute("list", productDao.list());
//		return "/WEB-INF/views/product/list.jsp";
		return "product/list";
	}

//	상세 요청 처리
//	[1] @ModelAttribute 사용하는 방법
//	@RequestMapping("/detail")
//	public String detail(@ModelAttribute ProductDto productDto, Model model) {}

//	[2] @RequestParam 사용하는 방법
	@RequestMapping("/detail")
	public String detail(@RequestParam int no, Model model) {
//		ProductDto productDto = productDao.get(no);
//		model.addAttribute("productDto", productDto);
		model.addAttribute("productDto", productDao.get(no));

//		return "/WEB-INF/views/product/detail.jsp";//전
		return "product/detail";//후
	}

//	[3] @PathVariable 사용하는 방법
	@RequestMapping("/detail/{no}")
	public String detail2(@PathVariable int no, Model model) {
		model.addAttribute("productDto", productDao.get(no));
		return "product/detail";
	}
	
}
