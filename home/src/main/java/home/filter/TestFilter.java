package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	필터(Filter)
 *	= 요청을 미리 검사하여 원치 않는 요청을 걸러내기 위해 개발된 도구
 *	= ex : 비회원이 회원 기능을 이용하려고 요청할 경우 이를 차단하는 필터(회원 필터)
 *	= 걸러내는 용도가 아니라 특정 요청에 무언가를 추가하는 용도로도 사용
 *	= ex : 매번 처리하기 귀찮은 req.setCharacterEncoding()을 자동 수행하는 필터(인코딩 필터)
 *
 *	생성 절차
 *	1. 상속을 통한 자격 획득(javax.servlet.Filter)
 *	2. @WebFilter 를 통한 등록 및 검사 주소 설정
 *	3. 메소드 재정의를 통하여 수행할 내용을 작성(doFilter 메소드)
 */
@WebFilter(urlPatterns = "/index.jsp")
public class TestFilter implements Filter{

	/**
	 * doFilter 메소드는 필터에서 수행할 작업을 정의하는 메소드
	 * 
	 * - ServletRequest 
	 * 		= HttpServletRequest의 상위 형태
	 * 		= 실제 사용할 때는 HttpServletRequest 유형의 객체가 들어간다
	 * - ServletResponse 
	 * 		= HttpServletResponse의 상위 형태
	 * 		= 실제 사용할 때는 HttpServletResponse 유형의 객체가 들어간다
	 * - FilterChain 은 필터끼리 서로 연결되어 있는 연결정보를 의미하며, 이를 이용하여 통과 명령을 사용할 수 있다.
	 * 		= 다음으로 이동하여 계속 진행하려면 사용자가 전달한 요청(request), 응답(response)이 유지되어야 한다.
	 * 		= 매개변수에 인자로 넣어서 전달해준다(유지시켜준다)
	 * 
	 * 	(결론) 
	 * 	Servlet에서 하던 작업을 Filter에서 하고 싶다면 request객체와 response객체를 "다운캐스팅" 해서 사용해야 한다.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//설치하고 아무런 코드도 작성하지 않으면 필터를 통과할 수 없다(대상에게 전달되지 않고 차단)
		//System.out.println("TestFilter 실행!");

		//요청을 통과시키고 싶다면 다음 명령을 사용
		chain.doFilter(request, response);

		//차단 명령
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;

		//resp.sendError(500);//오류(500)임을 알리고 차단
		//resp.sendRedirect("https://google.com");//다른 페이지로 재접속 지시(redirect)
	}

}
