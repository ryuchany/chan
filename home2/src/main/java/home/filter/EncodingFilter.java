package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 모든 요청에 대해서 UTF-8 변환 처리를 지시하는 보조 필터
 * 
 * <주소 규칙>
 * - 주소를 범위로 지정하고 싶다면 반드시 알아야 하는 규칙
 * 1. 엔드포인트(end-point)를 기준으로 와일드카드를 작성할 수 있다.(/로 시작해서 *로 끝나는 것이 가능)
 * 		= /*, /member/*, /admin/*, /board/* 
 * 2. 특정 유형의 확장자를 지정할 수 있다(*로 시작하는 것이 가능)
 * 		= *.jsp , *.txt, 등
 * 3. 1번과 2번을 동시에 할 수 없다.
 * 		= /member/*.txt는 불가능 패턴
 * 4. 특정 범위에서 주소를 제외하는 것이 불가능하다.(오로지 추가만 가능)
 */

//@WebFilter(urlPatterns= "/*")//서버 전체에 대한 요청
@WebFilter(urlPatterns={"*.jsp", "*.txt"})//JSP, Servlet 전체
public class EncodingFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//추가할 작업을 코드로 구현(간섭)
		HttpServletRequest req= (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);//모든 요청 통과
	}
}
