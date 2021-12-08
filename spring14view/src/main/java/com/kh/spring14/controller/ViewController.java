package com.kh.spring14.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring14.entity.ProductDto;

@Controller
public class ViewController {
	
	@RequestMapping("/test01")
	public String test01() {
		return "test01";
	}

	@RequestMapping("/test02")
	public String test02() {
		return "test02";
	}
	@RequestMapping("/test03")
	public String test03(HttpSession session, Model model) {
		session.setAttribute("memberId", "khmaster");
		model.addAttribute("lotto", 35);
		return "test03";
	}

	@RequestMapping("/test04")
	public String test04(Model model) {
		ProductDto productDto = new ProductDto();
		productDto.setNo(1);
		productDto.setName("메로나");
		productDto.setType("아이스크림");
		productDto.setPrice(1000);
		productDto.setMade("2021-12-07");
		productDto.setExpire("2021-12-31");

		model.addAttribute("productDto", productDto);

		return "test04";
	}
	
	@RequestMapping("/test05")
	public String test05() {
		return "test05";
	}
	
	@RequestMapping("/test06")
	public String test06(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6) + 1;

		model.addAttribute("dice", dice);

		return "test06";
	}

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/test07")
	public String test07(Model model) {
		model.addAttribute("list", sqlSession.selectList("product.perfectSearch"));
		return "test07";
	}
	
}
