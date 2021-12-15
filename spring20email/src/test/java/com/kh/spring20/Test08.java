package com.kh.spring20;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

//목표 : 복잡한 메세지(MimeMessage)를 전송하는 예제
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test08 {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void mimeMessageTest() throws MessagingException {
		//1. 메세지 객체 생성
		MimeMessage message = sender.createMimeMessage(); 

		//2. 설정 도우미 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

		//3. 정보 설정(helper)
		//= to, cc, bcc, subject, text 
		helper.setTo("asd1902@naver.com");

		helper.setSubject("마임메세지 테스트");

		//helper.setText("<h1>안녕</h1>");//일반 글자
		helper.setText("<h1>안녕</h1>", true);//HTML 글자

		//4. 전송(message)
		sender.send(message);
	}

}