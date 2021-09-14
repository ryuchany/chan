package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		Map<String, Car> rentList = new HashMap<>();

		rentList.put("스타렉스", new Car("스타렉스", 11, 150000));
		rentList.put("카니발", new Car("카니발", 7, 170000));
		rentList.put("그랜저", new Car("그랜저", 4, 200000));

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("차종을 입력하세요 : ");
			String name = sc.next();
			if (name.equals("종료")) {
				System.out.println("프로그램 종료");
				break;
			}

			if (rentList.containsKey(name)) {
				System.out.println("이 차량을 대여 / 반납 하시겠습니까?.");
				System.out.println("[대여] [반납] [뒤로가기]");
				String menu = sc.next();
				if (menu.equals("대여")) {
					if (rentList.get(name).isRental()) {
						System.out.println("대여가 완료되었습니다.");
						rentList.get(name).rentStart();
					} else {
						System.out.println("대여가 불가능합니다.");
					}
				} else if (menu.equals("반납")) {
					if (!rentList.get(name).isRental()) {
						System.out.println("반납 완료되었습니다.");
						rentList.get(name).rentEnd();
					} else {
						System.out.println("반납이 불가능합니다.");
					}

				} else if (menu.equals("뒤로가기")) {
				} else {
					System.out.println("없는 메뉴입니다.");
				}

			} else {
				System.out.println("존재하지 않는 차량입니다.");
			}

		}
		sc.close();
	}
}
