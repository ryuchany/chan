package api.exception;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		// Q : 원하는 범위에 예외 처리를 수행하여 "이상한 입력"이 발생한 경우 page가 1로 처리되도록 구현

		int page;

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("이동할 페이지 : ");
			page = sc.nextInt();
			sc.close();
		} catch (Exception e) {
			page = 1;
		}

		System.out.println("page = " + page);

	}
}
