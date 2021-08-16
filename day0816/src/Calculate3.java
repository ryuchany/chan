import java.lang.*;
public class Calculate3 {
	public static void main(String[] args) {
		//Q.5000원짜리 자장면 2그릇과 6000원짜리 짬뽕 2그릇을 주문할 때 자장면 합계, 짬뽕 합계, 총 가격 합계를 출력
		System.out.println(5000*2);
		System.out.println(6000*2);
		System.out.println(5000*2+6000*2);
		//문제점
		//1. 무슨 값이 얼마 인지 알 수 없다.
		//2. 매번 식을 입력 해야한다.
		//3. 자장면, 짬뽕, 개수 등이 변하면 식을 일일이 고쳐야 한다.
		
		int a = 5000*2; //a 라는 이름으로 5000 * 2의 결과를 저장하세요
		int b = 6000*2; //b 라는 이름으로 6000 * 2의 결과를 저장하세요
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(a+b);
	}
}
