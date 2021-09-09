package api.exception;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		// Test05의 문제점
		// = 잘못된 값(이상한 입력)에 대한 기준이 개발자와 Java가 서로 다르다
		// = 개발자는 정수가 아니거나 또는 0 이하의 정수는 잘못된 값이라고 생각한다
		// = Java는 정수가 아닌 것만 잘못된 값이라고 생각한다
		// ---> 0 이하의 정수가 입력된 경우도 잘못되었다고 "강제"로 알려준다
		// ---> 강제 예외
		// ---> 강제 예외를 발생시키기 위해서는 "예외 객체"를 수동으로 생성해야 한다.

		int page;

		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("이동할 페이지 : ");

			page = sc.nextInt();
			if (page <= 0) {
				// throw 뒤에 예외객체를 붙여서 catch 블록으로 강제 이동시킬 수 있다.
				// = catch 블록에 들어갈 수 있는 형태의 예외 객체를 만들어야 한다.
				Exception ex = new Exception();
				throw ex;
			}
		} catch (Exception e) {
			page = 1;
		}

		sc.close();
		System.out.println("page = " + page);

	}
}