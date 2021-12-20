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

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {

	@Test
	public void test() throws URISyntaxException {
		//우리 서버에서 카카오페이 서버로 신호를 보낼 수 있는가?
		//[1] HttpUrlConnection (java.net 패키지)
		//[2] RestTemplate (spring 기능)

		//1. 요청 도구 생성
		RestTemplate template = new RestTemplate();

		//2. 필요한 정보 추가(HTTP header, HTTP body)
		//2-1. HTTP Header 정보 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK add70f3b7cf356da658c07a929a2dd55");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		//2-2. HTTP Body 정보 생성
		//= cid를 제외한 나머지 정보들은 Test02를 진행한 뒤 확인이 가능
		//= cid는 테스트 개발용으로 "TC0ONETIME"을 사용
		//= tid, partner_order_id, partner_user_id는 Test02의 실행 결과에서 확인 가능
		//= pg_token은 Test02 실행 뒤 결제가 성공적으로 이루어지면 주소창의 파라미터에서 확인 가능
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", "T2977776418160365219");
		body.add("partner_order_id", "6eb468a3-a730-42de-b84e-c3db67aefb44");
		body.add("partner_user_id", "8dcad2f5-ffa7-4327-967f-d19b6f17660d");
		body.add("pg_token", "b33769b305530453e76b");

		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		//3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");

		//4. 요청방식에 따라 다른 명령으로 전송
		Map map = template.postForObject(uri, entity, Map.class);//응답을 기대하는 요청(JSON)
		log.debug("map = {}", map);
	}

}