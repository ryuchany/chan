package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test05 {
	public static void main(String[] args) {
		//저장소 생성
		Map<String, Car> map = new HashMap<>();

		//데이터 추가
		map.put("스타렉스", new Car("스타렉스", 11, 150000));
		map.put("카니발", new Car("카니발", 7, 170000));
		map.put("그랜저", new Car("그랜저", 4, 200000));
	}
}
