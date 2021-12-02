package com.kh.spring04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//주방 직원
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//처리할 내용이 있다면 처리하고, 연결될 화면(View)를 정하여 ModelAndView 형태로 반환
		ModelAndView mv = new ModelAndView();
		mv.addObject("a", 10);
		mv.addObject("b", 20);
		mv.setViewName("/WEB-INF/views/hello.jsp");
		return mv;
	}

}
