package com.kh.spring16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


//목표 : spring-security 에 존재하는 암호화 모듈을 이용해서 암호화 수행
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test05 {

	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void bcryptTest() {
		String origin = "khacademy";
		System.out.println("origin = " + origin);

		String encrypt = encoder.encode(origin);
		System.out.println("encrypt = " + encrypt);
		System.out.println("length = " + encrypt.length());

		//Q : origin으로 변환한 결과가 encrypt인지 어떻게 아는가? 매번 달라지는데?
		boolean match = encoder.matches(origin, encrypt);
		System.out.println("match = " + match);
	}

}
