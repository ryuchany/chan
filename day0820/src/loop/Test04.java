package loop;

import java.lang.*;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		// Q : 사용자에게 숫자를 하나 입력받아서 해당하는 숫자의 구구단을 출력해보세요

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		sc.close();

		for (int i = 1; i < 10; i++) {
			System.out.println(num + " X " + i + " = " + (num * i));
		}

	}
}