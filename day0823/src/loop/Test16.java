package loop;

import java.util.Scanner;

public class Test16 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("양수를 하나 입력 하세요.");
		int number = sc.nextInt();
		sc.close();

		int count = 0;
		for (int i = 1; i <= number; i++) {

			System.out.println(number + " % " + i + " = " + number % i);

			if (number % i == 0)
				count++;
		}

		System.out.println("count = " + count);

		if (count == 2) {
			System.out.println(number + "은 소수입니다");
		} else {
			System.out.println(number + "은 소수가 아닙니다 ");
		}
	}
}
