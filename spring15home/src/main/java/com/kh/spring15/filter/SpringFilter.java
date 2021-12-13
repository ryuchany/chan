package com.kh.spring15.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 *	Spring에서 권장하는 필터 사용 방식 
 *	= 필터는 스프링이 제어할 수 없는 상위 기관(자바 웹 애플리케이션)의 도구
 *	= web.xml에 최종적으로 등록되긴 해야 한다.
 *	= 스프링의 기능을 사용하려면 스프링 설정파일에 등록되어야 한다.
 *	= DispatcherServlet 아래로 갈 수는 없으므로 root-context.xml 등록
 *	= 등록한 뒤에 DelegatingProxyFilter 형태로 web.xml에 대리인 등록
 */
@Component
public class SpringFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Spring Filter!");
		chain.doFilter(request, response);
	}
}