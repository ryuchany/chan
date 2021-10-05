package api.lang.etc;

public class Test01 {
	public static void main(String[] args) {
		// Math 클래스
		// = 생성자가 없는 클래스
		// = Math 클래스는 다음 두 가지 경우 중 1번에 해당한다
		// 1. 모든 기능을 등록해두고 편하게 호출하려는 의도가 있는 경우(구성요소가 모두 static)
		// 2. 미리 객체를 만들어두고 그 객체만 사용하게 하려는 경우(싱글톤 방식. 구성요소가 static이 아님)

		// Math m = new Math();
		System.out.println(Math.PI);// 원주율
		System.out.println(Math.E);// 자연지수 e

		int a = 10;
		int b = 20;

		System.out.println(Math.abs(a - b));// abs : 절대값 계산 메소드
		System.out.println(Math.max(a, b));// max : 최대값 계산 메소드
		System.out.println(Math.min(a, b));// min : 최소값 계산 메소드

		double c = 1.5;
		System.out.println(Math.ceil(c));// 올림
		System.out.println(Math.round(c));// 반올림
		System.out.println(Math.floor(c));// 버림

		System.out.println(Math.random());// 랜덤

		int number = 8;
		System.out.println(Math.sqrt(number));

		System.out.println(Math.pow(2, 10));// 2의 10제곱

	}
}
