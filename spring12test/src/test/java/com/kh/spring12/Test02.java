package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *	스프링 환경 연동 테스트 
 *	- 스프링에 등록된 도구들을 불러와서 테스트를 수행하는 것
 *	- 연결된 모듈이나 도구들 없이 특정 기능을 테스트 할 수 있어 개발 및 테스트속도가 빠르다
 *	- 이러한 테스트를 기반으로 개발하는 방식을 TDD(테스트 주도 개발, Test Driven Development)라고 부른다
 *	- Spring-test에서 제공하는 애노테이션을 이용하여 스프링 환경 연동 설정을 한다.
 *	- @RunWith(SpringJUnit4ClassRunner.class) 를 통해 Spring과 연동할 것임을 명시
 *	- @ContextConfiguration 을 통하여 연동시킬 스프링 환경의 설정파일을 지정
 *		- root-context.xml
 *		- servlet-context.xml
 *	- @WebAppConfiguration 을 통하여 가상의 web.xml 을 만들도록 지시
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test02 {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		System.out.println(sqlSession);
	}

}
