package com.kh.spring20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
public class Test10 {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void mimeMessageTest() throws MessagingException, FileNotFoundException, IOException {
		//1. 메세지 객체 생성
		MimeMessage message = sender.createMimeMessage(); 

		//2. 설정 도우미 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

		//3. 정보 설정(helper)
		//= to, cc, bcc, subject, text 
		helper.setTo("asd1902@naver.com");

		helper.setSubject("KH정보교육원 12월 소식지");

		//4. 파일을 읽어서 내용을 설정
		//= src에 배치하면 ClassPath로 설정되기 때문에 손쉽게 읽을 수 있다.
		ClassPathResource resource = new ClassPathResource("email/template2.html");

		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile());){
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
				buffer.append('\n');
			}
		}
		
		String html = buffer.toString();
		html = html.replace("{{id}}", "asd1902@naver.com");
		helper.setText(html, true);

		//5. 전송(message)
		sender.send(message);
	}

}