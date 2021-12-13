package com.kh.spring18;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

//log4j의 출력 양식
@Slf4j
public class Test03 {

	@Test
	public void test() {
		int a = 10, b = 20, c = 30;
//		System.out.println(a, b, c);
//		System.out.println("a = " + a + " , b = " + b + " , c = " + c);
		log.debug("a = " + a + " , b = " + b + " , c = " + c);//기존 방식
		log.debug("a = {} , b = {} , c = {}", a, b, c);//홀더 방식
	}
}