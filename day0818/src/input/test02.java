package input;
import java.lang.*;
import java.util.Scanner;
public class test02 {
	public static void main(String[] args) {
		//목표 : Scanner 라는 도구를 활용하여 효과적으로 System.in 읽기 수행
		//= Scanner 기능 중에는 글자를 모아서 원하는 형태로 반환하는 기능이 있다
		//= 기본적으로 제공되는 도구가 아닌 추가로 만들어야 하는 도구는 생성 코드가 필요
		
		// 도구 생성
		Scanner sc = new Scanner(System.in);

		// 도구 사용
		int  a = sc.nextInt(); // 정수
		System.out.println("a = " + a );
		
		String b = sc.next(); // 문자열
		System.out.println("b = " + b);
				
		// 도구 종료(소멸)
		sc.close();
		
	}
}
