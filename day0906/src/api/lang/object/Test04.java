package api.lang.object;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		// Object가 모든 계층의 최상위라는 것을 증명
		// = 다형성 이용
		// = 다형성의 원리에 의하면 상위 클래스는 하위 클래스의 데이터를 보관할 수 있다(업 캐스팅)
		// = 따라서 Object가 진짜 최상위 클래스라면 자바의 모든 데이터는 Object로 저장이 가능해야 한다

		Object a = 10;
		Object b = 3.14;
		Object c = "Hello";
		Object d = new Random();
		Object sc = new Scanner(System.in);
		Object arr = new int[5];
		Object s = new Student();

	}
}
