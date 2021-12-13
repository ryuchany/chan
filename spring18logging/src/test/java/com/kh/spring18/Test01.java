package com.kh.spring18;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {

	//출력 도구 생성
	private Logger logger = LoggerFactory.getLogger(Test01.class);

	@Test
	public void test() {
		logger.debug("Hello debug");
		logger.info("Hello info");
		logger.warn("Hello warn");
		logger.error("Hello error");
	}

}