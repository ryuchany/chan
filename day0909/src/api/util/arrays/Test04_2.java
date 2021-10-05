package api.util.arrays;

import java.util.Arrays;

public class Test04_2 {
	public static void main(String[] args) {

		String a = "피카츄";
		String b = "피아노";

		//문자열의 크기라는 개념은 존재하지 않지만, 실생활에서는 가나다순으로 크기가 정해진다고 본다
		//= 문자열간의 차를 구해야 한다면, 글자와 연결된 값이 얼마인지를 계산하여 뺄셈을 수행한다

		char a1 = a.charAt(0);
		char b1 = b.charAt(0);
		System.out.println("a1 = " + a1 + "(" + (int)a1 + ")");
		System.out.println("b1 = " + b1 + "(" + (int)b1 + ")");
		System.out.println(b1 - a1);

		char a2 = a.charAt(1);
		char b2 = b.charAt(1);
		System.out.println("a2 = " + a2 + "(" + (int)a2 + ")");
		System.out.println("b2 = " + b2 + "(" + (int)b2 + ")");
		System.out.println(b2 - a2);

		System.out.println(b.compareTo(a));

	}
}
