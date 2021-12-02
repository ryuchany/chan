package com.kh.spring04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//처리 : 없음
		//연결(출력)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/home.jsp");
		return mv;
	}

}
