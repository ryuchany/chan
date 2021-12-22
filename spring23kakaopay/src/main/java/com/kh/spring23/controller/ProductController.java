package com.kh.spring23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring23.repository.ProductDao;
import com.kh.spring23.vo.ProductOrderListVO;
import com.kh.spring23.vo.ProductOrderVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("list", productDao.list());
		return "home";
	}

	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("list", productDao.list());
		return "test";
	}

	//객체 배열 파라미터는 반드시 @ModelAttribute로만 수신이 가능하다
	@PostMapping("/test")
	public String test(@ModelAttribute ProductOrderListVO vo) {
		log.debug("vo = {}", vo);
		return "redirect:test";
	}
}