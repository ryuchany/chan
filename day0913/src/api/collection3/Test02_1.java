package api.collection3;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;

public class Test02_1 {
	public static void main(String[] args) {
		Format f = new DecimalFormat("#,###");

		//저장소 생성
		Map<String, Integer> cars = new HashMap<>();

		//데이터 추가
		cars.put("K5", 12000000);
		cars.put("모닝", 5000000);
		cars.put("BMW", 40000000);

		//이름 준비
		String name = "K5";

		//문제점 : 없는 이름이 들어가면 예외 발생
		//[1] Integer로 만들면 null을 같이 저장할 수 있음
		Integer price = cars.get(name);
		if(price == null) {
			System.out.println("존재하지 않는 차량입니다");
		}
		else {
			System.out.println(name+"의 가격은 "+f.format(price)+"원 입니다");
		}

	}
}
