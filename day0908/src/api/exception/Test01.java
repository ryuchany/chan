package api.exception;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		// 예외(Exception)와 에러(Error)
		// = 원치 않는 상황이라는 공통점이 있다.
		// = 에러는 컴파일조차 되지 않는 상황(100% 실행이 안됨)
		// = 예외는 실행중 오류가 발생한 상황(경우에 따라서 실행이 될 수도 안될 수도 있다)

		Scanner sc = new Scanner(System.in);
		System.out.println("쿠폰 개수 입력");
		int a = sc.nextInt();
		System.out.println("인원 수 입력");
		int b = sc.nextInt();
		sc.close();
		int c = a / b;
		System.out.println("한 사람당 줄 수 있는 쿠폰 개수 = " + c);
		int d = a % b;
		System.out.println("남는 쿠폰 개수 = " + d);
	}
}
