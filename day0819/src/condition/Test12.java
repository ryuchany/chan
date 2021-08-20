package condition;

import java.lang.*;
import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력하세요");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		sc.close();

		// 처리
		int day;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		} else {
			boolean is400 = year % 400 == 0;
			boolean is4 = year % 4 == 0;
			boolean is100 = year % 100 == 0;
			if (is400 || is4 && !is100) {
				day = 29;
			} else {
				day = 28;
			}
		}
		// 결과
		System.out.println(day + "일 까지입니다.");

	}
}