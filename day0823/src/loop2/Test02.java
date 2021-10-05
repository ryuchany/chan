package loop2;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		// while 구문을 이용하면 "무한반복"이 가능하다(for도 가능하긴 하다)
		// 무한 반복 시 반드시 "종료상황"을 알려줘야 한다.
		// 0을 입력할 때까지 계속해서 숫자를 입력받는 프로그램 구현

		// while(true) {
		// System.out.println("Hello World!");
		// }

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("숫자 입력");
			int number = sc.nextInt();

			if (number == 0) { // 0을 입력했다면
				break; // 현재 진행중인 구문(if 빼고)을 탈출하세요!
			}
		}

		sc.close();
		System.out.println("종료");

	}
}
