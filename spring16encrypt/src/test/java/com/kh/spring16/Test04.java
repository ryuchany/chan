package com.kh.spring16;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

//목표 : spring-security 에 존재하는 암호화 모듈을 이용해서 암호화 수행
public class Test04 {

	@Test
	public void bcryptTest() {
		String origin = "khacademy";
		System.out.println("origin = " + origin);

//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		PasswordEncoder encoder = new SCryptPasswordEncoder();
		String encrypt = encoder.encode(origin);
		System.out.println("encrypt = " + encrypt);
		System.out.println("length = " + encrypt.length());

		//Q : origin으로 변환한 결과가 encrypt인지 어떻게 아는가? 매번 달라지는데?
		boolean match = encoder.matches(origin, encrypt);
		System.out.println("match = " + match);
	}

}
