package com.kh.spring04;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DiceController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 처리 : 주사위 값 1개 생성
		Random r = new Random();
		int dice = r.nextInt(6) + 1;//1부터 6개

		// 연결
		ModelAndView mv = new ModelAndView();
		mv.addObject("dice", dice);
		mv.setViewName("/WEB-INF/views/dice.jsp");
		return mv;
	}

}
