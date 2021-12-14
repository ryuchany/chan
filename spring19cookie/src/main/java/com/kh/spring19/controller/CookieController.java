package com.kh.spring19.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CookieController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/create")
	public String create(HttpServletResponse response) {
		//쿠키 생성
		Cookie c = new Cookie("test", "hello");
		//c.setMaxAge(10);//미지정 시 세션 쿠키로 관리됨(세션 만료시 사라짐)
		response.addCookie(c);
		return "redirect:/";
	}
	
	@RequestMapping("/drop")
	public String drop(HttpServletResponse response) {
		//쿠키 생성
		Cookie c = new Cookie("test", "hello");
		c.setMaxAge(0);
		response.addCookie(c);
		return "redirect:/";
	}

	@RequestMapping("/check")
	public String check(@CookieValue(required = false) String test) {
		log.debug("test = {}", test);
		if(test == null) {
			log.debug("쿠키가 없습니다");
		}
		else{
			log.debug("쿠키가 있습니다");
		}
		return "redirect:/";
	}
}