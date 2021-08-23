package loop;

import java.util.Scanner;

public class Test15 {
	public static void main(String[] args) {

		// 사용자에게 숫자를 입력받아서 해당 숫자에 ?이 몇개 들어있는지 세어서 출력
		// ex 숫자 입력 : 12752137 , 5 -> 5가 1개 있습니다

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 하세요.");
		int number = sc.nextInt();
		System.out.println("숫자를 한개 입력 하세요.");
		int select = sc.nextInt();

		sc.close();

		int count = 0;
		for (int i = number; i > 0; i /= 10) {
			int n = i % 10;

			if (n == select) {
				count++;
			}
		}

		System.out.println("입력하신 숫자 [" + number + "] 에는 " + select + "이(가) " + count + "개 있습니다.");

	}
}
