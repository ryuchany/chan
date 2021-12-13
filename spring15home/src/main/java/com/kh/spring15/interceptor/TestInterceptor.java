package com.kh.spring15.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *	인터셉터(Interceptor)
 *	= 스프링의 처리과정에 간섭할 수 있는 객체
 *	= AOP의 실제 구현체
 *	= 상속을 통해서 구현
 *	= DispatcherServlet의 작업에 간섭할 수 있다.
 *	= DispatcherServlet 설정파일인 servlet-context.xml에 등록해야 한다.
 */
public class TestInterceptor implements HandlerInterceptor{
	/**
	 * preHandle은 컨트롤러의 처리메소드가 실행되기 직전 시점을 간섭하는 메소드
	 * - return true일 경우 정상적인 진행 가능(허용)
	 * - return false일 경우 해당 요청은 진행 불가(차단)
	 * - 인터셉터는 HTTP 전용이므로 HttpServletRequest, HttpServletResponse를 제공
	 * - 일반적으로 필터와 비슷한 용도로 사용(차단 혹은 허용)
	 * - Object handler는 실행될 컨트롤러의 메소드 객체
	 * 		- 해당 메소드에 존재하는 애노테이션을 검사하거나 등의 처리를 수행할 수 있다.
	 * 		- java reflection이라는 기술을 전제조건으로 한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor의 preHandle 실행");
		return true;
	}

	/**
	 * postHandle은 컨트롤러의 작업 수행 직후에 간섭하는 메소드이다.
	 * - preHandle과는 다르게 요청을 차단할 수 없다(이미 실행이 시작됨)
	 * - 중간 확인 용도로 사용하는 경우가 많다
	 * - handler를 이용하여 실행한 기능을 확인할 수 있다.
	 * - modelAndView를 이용해서 처리 결과 모델 정보와 뷰 정보를 확인할 수 있다.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor의 postHandle 실행!");
		System.out.println(modelAndView);
	}

	/**
	 * afterCompletion은 View까지 완성된 이후의 상황을 간섭한다.
	 * - 화면을 만들면서 발생한 오류를 검사할 수 있다.
	 * - 오류 상황에 따라서 다른 처리를 수행하도록 추가 작업 지시를 내릴 수 있다.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor의 afterCompletion 실행!");
		System.out.println(ex);
	}

}