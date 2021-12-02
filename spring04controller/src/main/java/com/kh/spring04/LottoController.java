package com.kh.spring04;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LottoController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//처리 : 로또번호 생성
		Random r = new Random();
		int lotto = r.nextInt(45) + 1;

		//연결(출력)
		ModelAndView mv = new ModelAndView();
		mv.addObject("lotto", lotto);
		mv.setViewName("/WEB-INF/views/lotto.jsp");
		return mv;
	}

}
