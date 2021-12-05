package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.MemberDto;
import com.kh.spring09.entity.ProductDto;
import com.kh.spring09.repository.ProductDao;

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
	
	//상품목록
	@RequestMapping("/list")
	public String list(Model model) {

		List<ProductDto> list = productDao.list();
		model.addAttribute("list", list);

		return "product/list";//뷰리졸버 후
	}	
}
