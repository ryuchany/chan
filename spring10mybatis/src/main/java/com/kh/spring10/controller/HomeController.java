package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//메인 페이지로의 연결을 처리하는 컨트롤러
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
//		return "/WEB-INF/views/home.jsp";//ViewResolver 적용 전
		return "home";//ViewResolver 적용 후
	}
}

