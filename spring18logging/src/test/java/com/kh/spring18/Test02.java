package com.kh.spring18;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j//클래스 위에 @Slf4j 표시를 남기면 해당 클래스 정보로 Logger가 생성된다.
public class Test02 {

	@Test
	public void test() {
		log.debug("Hello debug");
		log.info("Hello info");
		log.warn("Hello warn");
		log.error("Hello error");
	}

}