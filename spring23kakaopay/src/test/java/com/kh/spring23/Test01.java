package com.kh.spring23;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
public class Test01 {
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
		headers.add("이름", "데이터");
		
		//2-2. HTTP Body 정보 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("이름", "데이터");
		
		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//3. 목적지 설정
		URI uri = new URI("요청보낼주소");

		//4. 요청방식에 따라 다른 명령으로 전송
		template.postForLocation(uri, entity);//응답을 기대하지 않는 단순요청
		//? = template.postForObject(uri, entity, 예상하는결과자료형);//응답을 기대하는 요청(JSON)
	}

}