package array;

import java.util.Scanner;

public class Test14 {

	public static void main(String[] args) {
		// 다음과 같은 데이터를 배열에 저장한 뒤 요구사항에 맞게 코드를 구현하세요
		// 데이터 : 30, 50, 20, 10, 40
		// 1. 배열 전체를 시계 방향으로 1번 회전
		// 2. 배열 전체를 사용자가 입력한 칸만큼 시계 방향으로 회전

		Scanner sc = new Scanner(System.in);
		System.out.print("회전 수를 입력하세요 : ");
		int rotate = sc.nextInt();
		sc.close();

		int[] data = new int[] { 30, 50, 20, 10, 40 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}

		System.out.println("");

		for (int n = 0; n < rotate; n++) {
			int temp = data[data.length - 1];
			for (int i = data.length - 1; i > 0; i--) {
				data[i] = data[i - 1];
			}
			data[0] = temp;
		}
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}
