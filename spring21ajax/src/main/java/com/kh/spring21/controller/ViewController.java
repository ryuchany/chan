package com.kh.spring21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring21.repository.ExamDao;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	ExamDao examDao;

	@GetMapping("/view1")
	public String view1() {
		return "view1";
	}

	@GetMapping("/view2")
	public String view2() {
		return "view2";
	}	
	
	@GetMapping("/view3")
	public String view3(Model model) {
		model.addAttribute("list", examDao.list());
		return "view3";
	}
	
	@GetMapping("/view4")
	public String view4() {
		return "view4";
	}
	
	@GetMapping("/view5")
	public String view5() {
		return "view5";
	}
	
	@GetMapping("/view6")
	public String view6() {
		return "view6";
	}
	
	@GetMapping("/view7")
	public String view7() {
		return "view7";
	}
	
	@GetMapping("/view8")
	public String view8() {
		return "view8";
	}	

	@GetMapping("/view9")
	public String view9() {
		return "view9";
	}	

	@GetMapping("/view10")
	public String view10() {
		return "view10";
	}

	@GetMapping("/view11")
	public String view11() {
		return "view11";
	}	
	
}