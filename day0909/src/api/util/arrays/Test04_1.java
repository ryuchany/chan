package api.util.arrays;

import java.util.Arrays;

public class Test04_1 {
	public static void main(String[] args) {

		String a = "피카츄";
		String b = "라이츄";

		//문자열의 크기라는 개념은 존재하지 않지만, 실생활에서는 가나다순으로 크기가 정해진다고 본다
		//= 문자열간의 차를 구해야 한다면, 글자와 연결된 값이 얼마인지를 계산하여 뺄셈을 수행한다

		char a1 = a.charAt(0);
		char b1 = b.charAt(0);
		System.out.println("a1 = " + a1 + "(" + (int)a1 + ")");
		System.out.println("b1 = " + b1 + "(" + (int)b1 + ")");
		System.out.println(b1 - a1);

		System.out.println(b.compareTo(a));

	}
}
