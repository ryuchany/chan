package oop.keyword3;

public class Test01 {

	public static void main(String[] args) {
		// 객체 생성
		PlusCalculator a = new PlusCalculator(10, 20);
		System.out.println(a.getTotal());

		PlusCalculator b = new PlusCalculator(100, 200);
		System.out.println(b.getTotal());

		// 문제점 : 굳이 이렇게까지..?
	}
}
