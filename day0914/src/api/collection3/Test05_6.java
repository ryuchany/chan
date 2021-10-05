package api.collection3;

import java.util.Scanner;

public class Test05_6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("명령 입력 (대여/반납/종료)");
			String command = sc.nextLine();

			if(command.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			else if(command.equals("대여")) {
				System.out.println("대여 기능을 실행합니다");
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
