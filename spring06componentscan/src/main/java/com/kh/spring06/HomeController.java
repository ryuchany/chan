package com.kh.spring06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("/WEB-INF/views/home.jsp");
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/welcome")
	public String welcome() {
//		return "/WEB-INF/views/welcome.jsp";
		return "welcome";
	}

}
