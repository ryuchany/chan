package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) {
		// Map<K, V>
		// = 개별 처리에 특화된 저장소
		// = 데이터에 이름을 붙여서 관리하는 형태
		// = K는 이름의 역할을 수행, V는 데이터의 역할을 수행
		// = K(key, 이름)는 중복이 불가능
		// = V(value, 값)는 중복이 가능

//		ex : 우리반 학생의 시험 점수
//		[1] 이름 : 피카츄 , 점수 : 50
//		[2] 이름 : 라이츄 , 점수 : 70
//		[3] 이름 : 파이리 , 점수 : 70

		Map<String, Integer> record = new HashMap<>();
//		Map<String, Integer> record = new TreeMap<>();

//		추가 : add()는 데이터를 1개 추가하는 명령. 2개는 put()이라는 명령을 사용
		record.put("피카츄", 50);
//		record.put(50, "피카츄");//예외 발생
		record.put("라이츄", 70);
		record.put("파이리", 70);

		System.out.println(record);
//		개수 확인 : size()
		System.out.println(record.size());

//		검색 명령 : contains() 대신 key와 value 검색명령을 따로 둔다. containsKey() , containsValue()
		System.out.println(record.containsKey("피카츄"));
		System.out.println(record.containsValue(70));

//		삭제 명령 : remove()
		record.remove("피카츄");
		System.out.println(record);

		int score = record.get("라이츄");// null이 나올 수 없는 경우
//		Integer score = record.get("라이츄");//null이 나올 수 있는 경우
		System.out.println(score);
	}
}
