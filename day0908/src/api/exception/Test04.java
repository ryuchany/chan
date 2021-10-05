package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) {
		// Test03의 문제점
		// = Exception을 사용해서 모든 예외를 처리한다는 점은 좋다!

		// 1. 예외를 구분하고 싶을 경우는 어떻게?
		// 2. 예외 메세지가 아예 사라져버렸는데 이를 확인할 방법은 없나?
		// ---> 예외 처리 블록에 존재하는 예외 정보 객체 (e)를 활용할 수 있다.

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
		} catch (Exception e) {// 예외만 처리하고 싶은 경우
			// System.err.println("프로그램에서 오류가 발생했습니다");

			// 에러 메세지(Stack Trace)를 다시 이전처럼 출력하는 명령
			// = 개발 단계에서 매우 유용하게 사용되며, 배포 후에는 삭제해야 하는 명령
			e.printStackTrace();

			// System.err.println(e.getClass());//예외 클래스 정보
			// System.err.println(e.getMessage());//내장된 원인 정보(null 일 수 있음)

			// JOptionPane.showMessageDialog(null, "오류가 발생했습니다");
		}
	}
}
