package output;
import java.lang.*;
public class test01 {
	public static void main(String[] args) {
		// 목표 : 표준 출력 통로(Sysout.out)를 이용 하는 방법
		//- println 명령 : 안에 적힌 글자 또는 수식을 계산하여 한 줄 단위로 출력
		//- print 명령 : 안에 적힌 글자 또는 수식을 계산하여 있는 그대로 출력
		//- printf 명령 : C언어 사용자들에게 친숙한 형태의 출력 방식
		// %d - 정수 출력 홀더 , %f - 실수, %c - 단일문자, %s - 문자열
		
		System.out.println("안녕하세요1");
		System.out.println("안녕하세요2");	
		
		System.out.print("안녕하세요3");
		System.out.print("안녕하세요4");
		
		// 줄바꿈 방법
		System.out.print("\n");
		System.out.println();
		
		System.out.println("안녕하세요5");	
		
		int a = 10;
		int b = 20;
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.print(", b = ");
		System.out.print(b);
		System.out.print("\n");
		
		System.out.println("a = " + a + ", b = " + b );
		
		System.out.printf("a = %d, b = %d\n",a,b);
	
	}
}
