package com.kh.spring15.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 *	(Q) 회원 기능에 회원만 접근할 수 있도록 인터셉터를 구현하세요 
 */
public class MemberInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String memberId = (String) request.getSession().getAttribute("ses");
		boolean isLogin = memberId != null;
		if(isLogin) {
			return true;
		}
		else {
			//response.sendRedirect(request.getContextPath()+"/member/login");
			response.sendError(401);
			return false;
		}
	}

}