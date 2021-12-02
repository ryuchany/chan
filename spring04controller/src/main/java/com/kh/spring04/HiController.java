package com.kh.spring04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HiController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//뭔가 할거 하고

		//내 뒤에 화면을 표시할 대상을 지정하고 종료
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/hi.jsp");
		return mv;
	}

}
