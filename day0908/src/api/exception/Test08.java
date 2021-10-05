package api.exception;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		// JDK 1.8부터는 "통로를 사용하는 try~catch" 구문은 자동 close()를 지원한다
		// ---> try~with 구문
		// ---> 통로 형태의 객체를 사용할 때만 필요한 형태
		// try(사용할 통로객체 생성) { 감시코드 } catch(예외객체 선언) { 처리코드 }
		// ---> finally 가 없어도 자동 close 수행

		int page;

		try (Scanner sc = new Scanner(System.in);) {
			System.out.print("이동할 페이지 : ");

			page = sc.nextInt();
			if (page <= 0) {
				// throw 뒤에 예외객체를 붙여서 catch 블록으로 강제 이동시킬 수 있다.
				// = catch 블록에 들어갈 수 있는 형태의 예외 객체를 만들어야 한다.
				Exception ex = new Exception();
				throw ex;// 강제 에러 발생
			}
		} catch (Exception e) {
			page = 1;
		}

		System.out.println("page = " + page);

	}
}