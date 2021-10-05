package api.util.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		System.out.print("연도 입력 : ");
		int year = sc.nextInt();

		System.out.print("월 입력 : ");
		int month = sc.nextInt();

		sc.close();

		c.set(Calendar.YEAR, year); // 시작 년도 설정
		c.set(Calendar.MONTH, (month) - 1); // 시작 월(-1) 설정
		c.set(Calendar.DAY_OF_MONTH, 1); // 시작 일 설정
		System.out.println("시작위치 : " + c.get(Calendar.DAY_OF_WEEK));
		System.out.println();

		System.out.println("< " + year + "년 " + month + "월 달력 >");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		c.set(Calendar.DAY_OF_WEEK, 1);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
				c.add(Calendar.DAY_OF_MONTH, 1);
			}
			System.out.println();
		}
	}
}
