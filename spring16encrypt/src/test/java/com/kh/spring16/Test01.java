package com.kh.spring16;

import org.junit.Test;

public class Test01 {

	/**
	 * 	암호화 / 복호화
	 * 	= 특정 대상만 알아들을 수 있는 글자
	 * 	= 양방향 / 단방향 암호화가 존재
	 */

	int offset = 3;

//	@Test
	public void caesar() {
		int origin = 123;
		System.out.println("origin = " + origin);

		int encrypt = origin + offset;
		System.out.println("encrypt = " + encrypt);

		int decrypt = encrypt - offset;
		System.out.println("decrypt = " + decrypt);
	}

	@Test
	public void caesar2() {
		String origin = "khacademy";
		System.out.println("origin = " + origin);

		StringBuffer encrypt = new StringBuffer();
		for(int i=0; i < origin.length(); i++) {
			char ch = origin.charAt(i);
			ch += offset;
			encrypt.append(ch);
		}
		System.out.println("encrypt = " + encrypt);

		StringBuffer decrypt = new StringBuffer();
		for(int i=0; i < encrypt.length(); i++) {
			char ch = encrypt.charAt(i);
			ch -= offset;
			decrypt.append(ch);
		}
		System.out.println("decrypt = " + decrypt);
	}

}
