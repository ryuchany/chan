package loop2;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//다음 요구사항에 맞는 프로그램을 while문을 이용하여 구현
		// 사용자에게 숫자를 입력받는다
		// 0을 입력하면 더이상 입력을 받지 않는다
		// 입력이 종료되면 여태까지 입력한 숫자의 홀수, 짝수 개수를 구하여 출력

		Scanner sc = new Scanner(System.in);

		int countOdd = 0; // 홀수
		int countEven = 0; // 짝수

		while (true) {
			System.out.println("숫자 입력");
			int number = sc.nextInt();

			if (number == 0) {
				break;
			}

			if (number % 2 == 0) {
				countEven++;
			} else {
				countOdd++;
			}
		}

		System.out.println("홀수는 총 " + countOdd + "번 입력되었습니다.");
		System.out.println("짝수는 총 " + countEven + "번 입력되었습니다.");
		System.out.println("홀수 = " + countOdd + "개, " + "짝수 = " + countEven + "개");

		sc.close();

	}
}
