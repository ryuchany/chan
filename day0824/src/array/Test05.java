package array;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {

		//사용자에게 5명의 이름을 입력받아 출력
		String[] name = new String[5]; // 이름

		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 5번 입력하세요");

		for (int i = 0; i < 5; i++) {
			name[i] = sc.nextLine();
		}
		sc.close();

		for (int i = 0; i < 5; i++) {
			System.out.println(name[i]);
		}

	}
}
