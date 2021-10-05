package loop;

import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("날짜 입력");
		int period = sc.nextInt();
		sc.close();

		long total = 0;
		long money = 1;
		for (int i = 1; i <= period; i++) {
			System.out.println(i + "일 = " + money + "원");
			total += money;
			money *= 2;
		}
		System.out.println("");
		System.out.println(period + "일 총 금액 = " + total + "원");
	}
}
