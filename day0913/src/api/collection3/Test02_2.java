package api.collection3;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02_2 {
	public static void main(String[] args) {
		Format f = new DecimalFormat("#,###");
		Scanner sc = new Scanner(System.in);

		// 저장소 생성
		Map<String, Integer> cars = new HashMap<>();

		// 데이터 추가
		cars.put("K5", 12000000);
		cars.put("모닝", 5000000);
		cars.put("BMW", 40000000);

		// 이름 준비
		String name = sc.next();
		sc.close();
		// 문제점 : 없는 이름이 들어가면 예외 발생
		// [2] Map의 containsKey() 메소드 활용
		if (cars.containsKey(name)) {
			int price = cars.get(name);
			System.out.println(name + "의 가격은 " + f.format(price) + "원 입니다");
		} else {
			System.out.println("존재하지 않는 차량입니다");
		}

	}
}
