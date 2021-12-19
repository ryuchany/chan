package com.kh.spring22.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring22.vo.UserVO;

@Controller
public class ViewController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam String userId) {
		session.setAttribute("userId", userId);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}


	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	@GetMapping("/manage")
	public String manage() {
		return "manage";
	}
	
	@GetMapping("/message")
	public String message() {
		return "message";
	}
	
	@GetMapping("/json")
	public String json() {
		return "json";
	}

	@GetMapping("/member")
	public String member() {
		return "member";
	}

	@GetMapping("/sockjs")
	public String sockjs() {
		return "sockjs";
	}	
	
}