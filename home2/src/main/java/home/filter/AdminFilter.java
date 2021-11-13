package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 	현재 세션에는 ses라는 이름으로 회원 아이디가 저장되어 있음
			관리자인지 확인하려면
			[1] 회원아이디를 이용하여 단일조회 실시(DB 접속)
			[2] 로그인 성공 시 세션에 회원 권한(grade)도 저장
			
			우리는 [2]를 사용하여 처리한다.
		 */

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();

		String grade = (String)session.getAttribute("grade");
		boolean admin = grade != null && grade.equals("관리자");

		if(admin) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendError(403);//forbidden, 권한 부족
		}
	}
}
