package array;

public class Test01 {

	public static void main(String[] args) {
		
		//변수 : 단일 데이터 저장소
		//배열 : 다중 데이터 저장소

		//= 배열은 변수만으로 처리하기 어려워서 나온 개념
		//= 어떤 상황에서 변수로 처리하는 것이 어려운지 파악하는 것이 중요!

		//10, 20, 30, 40, 50 이라는 숫자를 저장 및 합계계산 후 출력
		int a, b, c, d, e;

		a = 10;
		b = 20;
		c = 30;
		d = 40;
		e = 50;

		int total = a + b + c + d + e;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);

		System.out.println("total = " + total);
	}
}
