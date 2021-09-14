package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test06 {
	public static void main(String[] args) {
		//Q : Map이 개별 저장소인건 알겠는데... 전체 목록 출력은 아예 안되는건가?
		//A : 되긴 되는데... map에서 key 목록을 추출하는 명령이 필요하다.

		Map<String, Integer> map = new HashMap<>();

		map.put("피카츄", 75);
		map.put("라이츄", 65);
		map.put("파이리", 90);

		System.out.println("피카츄 : "+map.get("피카츄"));
		System.out.println("라이츄 : "+map.get("라이츄"));
		System.out.println("파이리 : "+map.get("파이리"));
	}
}
