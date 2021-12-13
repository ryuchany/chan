package com.kh.spring15.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.spring15.repository.MemberDao;
import com.kh.spring15.repository.MemberDaoImpl;

/**
 *	과거 JSP/Servlet 프로젝트에서 사용하던 방식의 필터 
 *	= 필터와 서블릿을 기존 방식처럼 @WebFilter, @WebServlet으로 등록하면 web.xml 에 등록됨
 *	= 스프링의 기능을 하나도 사용할 수 없어서 문제가 된다
 *	= @Autowired 를 이용한 주입 등이 모두 불가능하다.
 */
//@WebFilter(urlPatterns = "/*")
public class LegacyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

}
