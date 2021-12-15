package com.kh.spring20;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.entity.CertificationDto;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test05 {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		CertificationDto certificationDto = new CertificationDto();
		certificationDto.setEmail("chanytest12@gmail.com");
		certificationDto.setSerial("123456");

		sqlSession.insert("certification.insert", certificationDto);
	}

}