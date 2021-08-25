package array;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// 사용자에게 3개의 숫자를 배열에 입력받아 합계를 계산한 뒤 출력
		int[] arr = new int[3];
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 3개 입력");
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int total = 0;
		for (int i = 0; i < 3; i++) {
			total += arr[i];
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("점수 = " + arr[i]);
		}
		System.out.println("total = " + total);

	}
}
