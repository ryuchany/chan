package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test05_7 {
	public static void main(String[] args) {
		//저장소 생성
		Map<String, Car> map = new HashMap<>();

		//데이터 추가
		map.put("스타렉스", new Car("스타렉스", 11, 150000));
		map.put("카니발", new Car("카니발", 7, 170000));
		map.put("그랜저", new Car("그랜저", 4, 200000));

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("명령 입력 (대여/반납/종료)");
			String command = sc.nextLine();

			if(command.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			else if(command.equals("대여")) {
				System.out.print("차량명 입력 : ");
				String name = sc.nextLine();

				if(map.containsKey(name)) {
					Car find = map.get(name);
					if(find.isRent()) {
						System.out.println("대여 가능한 차량입니다");
						find.rental();//find.setRent(false);//대여 처리
						System.out.println("대여 처리가 완료되었습니다");
					}
					else {
						System.out.println("대여중인 차량입니다");
					}
				}
				else {
					System.out.println("차량이 존재하지 않습니다");
				}
			}
			else if(command.equals("반납")) {
				System.out.println("반납 기능을 실행합니다");
			}
			else {
				System.out.println("잘못 입력하셨습니다");
			}
		}

		sc.close();


	}
}
