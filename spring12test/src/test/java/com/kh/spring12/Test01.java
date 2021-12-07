package com.kh.spring12;

import org.junit.Test;

public class Test01 {

	/**
	 * JUnit 독립 테스트
	 * - 어떠한 기능 연계도 없이 단순한 코드를 테스트 하고 싶은 경우 사용
	 * - 메소드의 형태를 public void 이름(){ ... } 으로 만든다
	 * - 메소드 상단에 @Test 애노테이션을 사용하여 테스트 메소드임을 표시한다
	 */

	@Test
	public void test() {
		System.out.println("Hello world!");
	}

}
