package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RentApp {
	private Map<String, Car> map = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public RentApp() {
		// 데이터 추가
		map.put("스타렉스", new Car("스타렉스", 11, 150000));
		map.put("카니발", new Car("카니발", 7, 170000));
		map.put("그랜저", new Car("그랜저", 4, 200000));
	}

	public String menu() {// 메뉴
		System.out.println("<KH 렌트카>");
		System.out.println("저희 KH 렌트카는 항상 친절과 정성으로 고객을 모시겠습니다~");
		System.out.println("원하시는 명령을 입력해주세요");
		System.out.println("- 대여");
		System.out.println("- 반납");
		System.out.println("- 종료");
		System.out.print("명령 입력 : ");
		String command = sc.nextLine();
		return command;
	}

	public void exit() {// 종료
		System.out.println("프로그램을 종료합니다");
		sc.close();
		System.exit(0);
	}

	public void rental() {// 대여
		System.out.print("차량명 입력 : ");
		String name = sc.nextLine();

		if (map.containsKey(name)) {
			Car find = map.get(name);
			if (find.isRent()) {
				System.out.println("대여 가능한 차량입니다");
				find.rental();// find.setRent(false);//대여 처리
				System.out.println("대여 처리가 완료되었습니다");
			} else {
				System.out.println("대여중인 차량입니다");
			}
		} else {
			System.out.println("차량이 존재하지 않습니다");
		}
	}

	public void rentalReturn() {// 반납
		System.out.print("차량명 입력 : ");
		String name = sc.nextLine();

		if (map.containsKey(name)) {
			Car find = map.get(name);
			if (!find.isRent()) {
				System.out.println("반납 가능한 차량입니다");
				find.setRent(true);// 반납 처리
				System.out.println("반납 처리가 완료되었습니다");
			} else {
				System.out.println("대여중인 차량이 아닙니다");
			}
		} else {
			System.out.println("차량이 존재하지 않습니다");
		}
	}

	public void information() {
		System.out.println("잘못 입력하셨습니다");
	}

	public void action(String command) {
//		if(command.equals("종료")) {
//			this.exit();
//		}
//		else if(command.equals("대여")) {
//			this.rental();
//		}
//		else if(command.equals("반납")) {
//			this.rentalReturn();
//		}
//		else {
//			this.information();
//		}
		switch (command) {
		case "종료":
			this.exit();
			break;
		case "대여":
			this.rental();
			break;
		case "반납":
			this.rentalReturn();
			break;
		default:
			this.information();
			break;
		}
	}

	public void run() {
		while (true) {
			try {
				String command = this.menu();
				this.action(command);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류 발생. 관리자에게 문의하세요");
			}
		}
	}
}
