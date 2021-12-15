package com.kh.spring20;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.entity.CertificationDto;
import com.kh.spring20.repository.CertificationDao;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test07 {

	@Autowired
	private CertificationDao certificationDao;

	@Test
	public void checkTest() {
		CertificationDto certificationDto = new CertificationDto();
		certificationDto.setEmail("asd1902@naver.com");
		certificationDto.setSerial("091158");

		assertTrue(certificationDao.check(certificationDto));
	}

}