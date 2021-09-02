package oop.keyword4;

public class Test01 {
	public static void main(String[] args) {
		//static 키워드가 붙은 대상은 "객체 없이" 접근이 가능하다.
		//= 다양한 형태로 활용이 가능하며
		//= 이 예제에서는 "단순한데 많이 사용하는 계산"을 객체 생성 없이 처리하도록 구현
		System.out.println(MinusCalculator.minus(30, 20));
	}
}
