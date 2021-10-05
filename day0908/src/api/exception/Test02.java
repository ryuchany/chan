package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		//Q : 프로그램에서 예외가 발생하는 상황과 예외의 이름을 조사해보세요.
		//A : 이 프로그램에서 발생할 것으로 예상되는 예외는 2가지
		//= java.util.InputMismatchException
		//= java.lang.ArithmeticException

		//예외를 발생하지 않게 만들 수는 없다
		//= 예외가 발생한 경우에 예외 메세지 출력 대신 다른 행위를 할 수는 있다.
		//= try ~ catch 구문을 통해 해결!
		//= try는 문제가 발생할 것으로 예상되는 지역을 감시하는 영역(CCTV)
		//= catch는 발생한 문제에 대한 처리를 수행하는 영역(경찰서)

		try {//문제 발생 코드 + 정상 실행 결과 코드
			Scanner sc = new Scanner(System.in);
			System.out.println("쿠폰 개수 입력");
			int a = sc.nextInt();
			System.out.println("인원 수 입력");
			int b = sc.nextInt();
			sc.close();

			int c = a / b;
			System.out.println("한 사람당 줄 수 있는 쿠폰 개수 = " + c);
			int d = a % b;
			System.out.println("남는 쿠폰 개수 = "+d);
		}
		catch(InputMismatchException e){//InputMismatchException 발생 시 실행할 코드 작성
			System.err.println("입력 똑바로해! 정신차려!");
		}
		catch(ArithmeticException e){//ArithmeticException 발생 시 실행할 코드 작성
			System.err.println("사람이 없는게 말이 되냐? 어?");
		}
	}
}


