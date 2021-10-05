package character;
import java.lang.*;
public class test03 {
	public static void main(String[] args) {
		//문자열의 특징
		//1. (원래 안되는건데 특별히) 덧셈만 가능하다
		// = 어떠한 형태와 더해도 결과가 문자열로 나온다
		//2. 문자열에서 정상적으로 출력되지 않는 글자들이 있다.
		// = 특수한 형태를 표현하기 위한 글자
		// = \n (New Line, 개행) - 다음 행으로 이동
		// = \t (Tab, 탭) - 다음 탭으로 이동
		// = \r (caRriage return) - 첫 칸으로 이동
		// = \", \', \\
		
		System.out.println("안녕하세요" + 1); // 안녕하세요1
		System.out.println("안녕하세요" + 1 + 2); // 안녕하세요12
		
		int a = 10;
		int b = 20;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//System.out.println("합계 = " + a + b); -> 왼쪽부터 계산 문자열로 인식
		int total = a+b;
		System.out.println("합계 = " + total);
	
		//2
		//나는 지금 "피자"가 먹고싶다
		String str = "나는 지금 \"피자\"가 먹고싶다";
		System.out.println(str);
		
		String str2 = "안녕\t하세요";   //TAB키 쓰는법
		System.out.println(str2);
		
		String str3 = "안\n녕\n하\n세\n요"; //ENTER키 쓰는법
		System.out.println(str3);
		
		String str4 = "C:\\java";
		System.out.println(str4);		
	}
}
