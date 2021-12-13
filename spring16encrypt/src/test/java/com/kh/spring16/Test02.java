package com.kh.spring16;

import org.junit.Test;

public class Test02 {

	int offset = 63;

//	@Test
	public void xor() {
		int origin = 123;
		System.out.println("origin = " + origin);

		int encrypt = origin ^ offset;
		System.out.println("encrypt = " + encrypt);

		int decrypt = encrypt ^ offset;
		System.out.println("decrypt = " + decrypt);
	}

	@Test
	public void xor2() {
		String origin = "khacademy";
		System.out.println("origin = " + origin);

		StringBuffer encrypt = new StringBuffer();
		for(int i=0; i < origin.length(); i++) {
			char ch = origin.charAt(i);
			ch ^= offset;
			encrypt.append(ch);
		}
		System.out.println("encrypt = " + encrypt);

		StringBuffer decrypt = new StringBuffer();
		for(int i=0; i < encrypt.length(); i++) {
			char ch = encrypt.charAt(i);
			ch ^= offset;
			decrypt.append(ch);
		}
		System.out.println("decrypt = " + decrypt);
	}

}
