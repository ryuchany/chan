import java.lang.*;
public class Calculate4 {
	public static void main(String[] args) {
		//문제점
		//1. 무슨 값이 얼마 인지 알 수 없다.
		//2. 매번 식을 입력 해야한다.
		//3. 자장면, 짬뽕, 개수 등이 변하면 식을 일일이 고쳐야 한다.
		
		int c = 5000; // 자장면 가격
		int d = 3; // 자장면 수량
		int e = 6000; // 짬뽕 가격
		int f = 2; // 짬뽕 수량
		
		int a = c*d; //a 라는 이름으로 c * d의 결과를 저장하세요
		int b = e*f; //b 라는 이름으로 e * f의 결과를 저장하세요
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(a+b);
	}
}
