package com.kh.spring20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

//Spring에 등록한 JavaMailSenderImpl이 정상적으로 작동하는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test02 {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void test() {
		log.debug("sender = {}", sender);

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo("asd1902@naver.com");
//		message.setCc("zdlsz@hanmail.net", "hiphop5782@naver.com");
		message.setSubject("[KH정보교육원] 인증번호 메일입니다");
		message.setText("인증번호는 123456 입니다");

		sender.send(message);
	}

}