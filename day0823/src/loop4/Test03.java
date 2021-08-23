package loop4;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("시작 구간을 입력하세요 = ");
		int go = sc.nextInt();
		System.out.print("종료 구간을 입력하세요 = ");
		int stop = sc.nextInt();
		sc.close();

		int clap = 0;

		for (int i = go; i <= stop; i++) {

			for (int j = i; j > 0; j /= 10) {

				if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {

					clap++;

				}
			}
		}

		System.out.println(go + "에서 " + stop + "까지");
		System.out.println("박수친 횟수 = " + clap + "번");

	}
}
