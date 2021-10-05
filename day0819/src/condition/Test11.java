package condition;

import java.lang.*;
import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("초를 입력하세요");
		int second = sc.nextInt();
		sc.close();

		// 처리
		// String message = "방금 전" or "?초 전" or "?분 전" or "?시간 전" or "오래 전";
		String message;
		if (second <= 10) {
			message = "방금 전";
		} else if (second < 60) {
			message = second + "초 전";
		} else if (second < 60 * 60) {
			int minute = second / 60;
			message = minute + "분 전";
		} else if (second < 24 * 60 * 60) {
			int hour = second / 60 / 60;
			message = hour + "시간 전";
		} else {
			message = "오래 전";
		}

		// 출력
		System.out.println(message);

	}
}