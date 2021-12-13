package com.kh.spring16;

import org.junit.Test;

public class Test03 {

	/**
	 * 단방향 암호화는 암호화된 결과를 토대로 원본을 예측할 수 없어야 한다.
	 * 하지만 충돌(Collision)이 발생하면 안된다.
	 * 충돌이란 서로 다른 두 개의 값이 같은 결과가 나오면 안된다.
	 * 암호가 무엇이냐가 중요한 것이 아니고 구분만 되면 되므로 알아볼 수 없게 만든다.
	 * (중요) 단방향 암호화는 의도적으로 손실을 발생시키는데 결과가 원본보다 무조건 커야 한다.
	 */
//	@Test
	public void encrypt() {
		int origin = 9;
		System.out.println("origin = " + origin);

		int encrypt = origin * 12345 % 100;
		System.out.println("encrypt = " + encrypt);

//		int decrypt = ?
	}

	@Test
	public void encrypt2() {
		String origin = "khacademy";
		System.out.println("origin = " + origin);

		StringBuffer encrypt = new StringBuffer();
		for(int i=0; i < origin.length(); i++) {
			char ch = origin.charAt(i);
			ch *= 12345;
			ch %= 100;
			encrypt.append(ch);
		}
		System.out.println("encrypt = " + encrypt);
	}

}
