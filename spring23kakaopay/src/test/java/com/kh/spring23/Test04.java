package com.kh.spring23;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring23.vo.KakaoPaySearchResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {

	@Test
	public void detailTest() throws URISyntaxException {
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK add70f3b7cf356da658c07a929a2dd55");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", "T2978112821473885255");//존재하는 TID를 작성

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");

		//Map map = template.postForObject(uri, entity, Map.class);
		//log.debug("map = {}", map);
		KakaoPaySearchResponseVO responseVO = template.postForObject(uri, entity, KakaoPaySearchResponseVO.class);
		log.debug("responseVO = {}", responseVO);
	}

}