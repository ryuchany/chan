package oop.keyword4;

//계산기 : 클래스 : 뺄셈 전용
//= 뺄셈과 같은 단순한 1회성 계산에 객체까지 쓰려니까 너무 복잡하다
//= 멤버변수, 멤버메소드 등을 구현하지 말고 1회용 메소드를 생성하자!
public class MinusCalculator {
	
	public static int minus(int left, int right) {
		return left - right;
	}
}
