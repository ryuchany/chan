package com.kh.spring23;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Test02 {
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
		String partner_order_id = UUID.randomUUID().toString();
		String partner_user_id = UUID.randomUUID().toString();
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", partner_order_id);//랜덤시리얼
		body.add("partner_user_id", partner_user_id);//랜덤시리얼
		body.add("item_name", "자바수강권");
		body.add("quantity", "1");
		body.add("total_amount", "50000");
		body.add("tax_free_amount", "0");
		
		//카카오서버에게 결제 결과에 따른 페이지를 미리 안내(단, 애플리케이션에 등록된 주소만 가능)
		body.add("approval_url", "http://localhost:8080/spring23/pay/success");
		body.add("cancel_url", "http://localhost:8080/spring23/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring23/pay/fail");
		
		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//4. 요청방식에 따라 다른 명령으로 전송
		//Map map = template.postForObject(uri, entity, Map.class);//응답을 기대하는 요청(JSON)
		//log.debug("map = {}", map);

		KakaoPayReadyResponseVO vo = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		//log.debug("vo = {}", vo);

		System.out.println(vo.getTid());
		System.out.println(partner_order_id);
		System.out.println(partner_user_id);
		System.out.println(vo.getNext_redirect_pc_url());
	}

}