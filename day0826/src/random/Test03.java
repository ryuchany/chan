package random;

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		// 사용자에게 랜덤으로 구구단 1문제를 출제하여
		// 정답을 입력받고 맞았는지 틀렸는지 판정하여 출력
		// 2 X 3 = 6 정답입니다
		// 5 X 7 = 32 오답입니다

		Random r = new Random();
		int number = r.nextInt(8) + 2;
		int number2 = r.nextInt(9) + 1;
		System.out.print(number + " X " + number2 + " = ");

		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
		sc.close();

		if (number * number2 == answer) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("오답입니다.");
		}

	}
}
