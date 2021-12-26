package com.kh.spring26.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	//home.jsp와 연결되도록 루트페이지(/)를 구성
	@RequestMapping("/")
	public String home() {
		log.info("홈페이지 접속");
		return "home";
	}
	
}