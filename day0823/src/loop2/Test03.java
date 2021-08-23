package loop2;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//다음 요구사항에 맞는 프로그램을 while문을 이용하여 구현
		// 사용자에게 숫자를 입력받는다
		// 입력받은 숫자를 계속 더하여 100이 넘어가면 입력을 중지한다.
		// 프로그램 종료시 화면에 Game over 라고 출력한다

		Scanner sc = new Scanner(System.in);

		int total = 0;
		int round = 1;

		while (true) {
			System.out.println("Round = " + round + " 숫자 입력");

			int input = sc.nextInt();

			total += input;
			// System.out.println("input = " + input + ", total = " + total);

			if (total > 100) {
				break;
			}
			round++;
		}

		System.out.println(total + " , " + "Game over");

		sc.close();

	}
}
