package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test05_4 {
	public static void main(String[] args) {
		//저장소 생성
		Map<String, Car> map = new HashMap<>();

		//데이터 추가
		map.put("스타렉스", new Car("스타렉스", 11, 150000));
		map.put("카니발", new Car("카니발", 7, 170000));
		map.put("그랜저", new Car("그랜저", 4, 200000));

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("차량명 입력 : ");
			String name = sc.nextLine();
			if(name.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}

			if(map.containsKey(name)) {
				Car find = map.get(name);
				if(find.isRent()) {
					System.out.println("대여 가능한 차량입니다");
				}
				else {
					System.out.println("대여중인 차량입니다");
				}
			}
			else {
				System.out.println("차량이 존재하지 않습니다");
			}
		}

		sc.close();
	}
}
