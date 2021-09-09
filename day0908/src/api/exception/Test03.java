package api.exception;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		// Test02의 문제점
		// 1. 발생하는 예외가 정말 두 종류 뿐인지 알 수가 없고
		// 2. 두 종류라고 해서 처리블록을 두 개를 만드는게 맞는건지 알 수 없다.
		// ---> 예외를 통합해서 처리할 수도 있나? 가능!
		// ---> 공통된 부모 클래스인 RuntimeException 클래스를 이용하여 하나의 catch 블록으로 통합

		try {// 문제 발생 코드 + 정상 실행 결과 코드
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
//		catch(RuntimeException e){
		catch (Exception e) {// 예외만 처리하고 싶은 경우
//		catch(Throwable e) {//에러까지 처리하고 싶은 경우
			System.err.println("프로그램에서 오류가 발생했습니다");
		}
	}
}
