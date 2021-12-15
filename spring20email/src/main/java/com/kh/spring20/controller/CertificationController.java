package com.kh.spring20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring20.entity.CertificationDto;
import com.kh.spring20.repository.CertificationDao;
import com.kh.spring20.service.EmailService;

@Controller
public class CertificationController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private CertificationDao certificationDao;

	@GetMapping("/")
	public String root() {
		return "root";
	}

	@PostMapping("/")
	public String cert(@RequestParam String email, Model model) {
		emailService.sendCertificationNumber(email);
		model.addAttribute("email", email);
		return "check";
	}

	@PostMapping("/check")
	public String check(@ModelAttribute CertificationDto certificationDto) {
		boolean success = certificationDao.check(certificationDto);
		if(success) {
			return "redirect:/success";//절대경로
//			return "redirect:success";//상대경로
		}
		else {
			return "redirect:/?error";
		}
	}

	@GetMapping("/success")
	public String success() {
		return "success";
	}
}