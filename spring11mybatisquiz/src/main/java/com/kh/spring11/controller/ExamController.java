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

import com.kh.spring11.entity.ExamDto;
import com.kh.spring11.repository.ExamDao;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamDao examDao;

	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/exam/insert.jsp";
		return "exam/insert";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute ExamDto examDto) {
		examDao.insert(examDto);
//		return "redirect:/";
//		return "redirect:/exam/insert";
		return "redirect:insert";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", examDao.list());
//		return "/WEB-INF/views/exam/list.jsp";
		return "exam/list";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam int examId, Model model) {
		model.addAttribute("examDto", examDao.get(examId));
//		return "/WEB-INF/views/exam/detail.jsp";
		return "exam/detail";
	}

	@RequestMapping("/detail/{examId}")
	public String detail2(@PathVariable int examId, Model model) {
		model.addAttribute("examDto", examDao.get(examId));
		return "exam/detail";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam String student, Model model) {
		model.addAttribute("list", examDao.search(student));
//		return "/WEB-INF/views/exam/list.jsp";
		return "exam/list";
	}

	@RequestMapping("/search2")
	public String search2(
			@RequestParam String column, @RequestParam String keyword,
			Model model) {
		model.addAttribute("list", examDao.search(column, keyword));
		return "exam/list";
	}	
	
}
