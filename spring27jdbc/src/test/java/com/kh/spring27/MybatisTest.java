package com.kh.spring27;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MybatisTest {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		log.debug("sqlSession = {}", sqlSession);
		assertNotNull(sqlSession);
	}

}