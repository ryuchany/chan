package com.kh.spring23;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring23.service.KakaoPayService;
import com.kh.spring23.vo.KakaoPaySearchResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test05 {

	@Autowired
	private KakaoPayService kakaoPayService;

	@Test
	public void searchTest() throws URISyntaxException {
		String tid = "T2978112821473885255";

		KakaoPaySearchResponseVO responseVO = kakaoPayService.search(tid);
		log.debug("responseVO = {}", responseVO);
	}

}