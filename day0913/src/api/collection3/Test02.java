package api.collection3;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;

public class Test02 {
	public static void main(String[] args) {
		Format f = new DecimalFormat("#,###");

		// 저장소 생성
		Map<String, Integer> cars = new HashMap<>();

		// 데이터 추가
		cars.put("K5", 12000000);
		cars.put("모닝", 5000000);
		cars.put("BMW", 40000000);

		// 이름 준비
		String name = "아우디";

		// 문제점 : 없는 이름이 들어가면 예외 발생
		int price = cars.get(name);
		System.out.println(name + "의 가격은 " + f.format(price) + "원 입니다");

	}
}
