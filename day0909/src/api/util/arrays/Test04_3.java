package api.util.arrays;

import java.util.Arrays;

public class Test04_3 {
	public static void main(String[] args) {

		String a = "피카츄";
		String b = "피아노";

		//문자열의 크기라는 개념은 존재하지 않지만, 실생활에서는 가나다순으로 크기가 정해진다고 본다
		//= 문자열간의 차를 구해야 한다면, 글자와 연결된 값이 얼마인지를 계산하여 뺄셈을 수행한다

		for(int i=0; i < Math.min(a.length(), b.length()); i++) {
			char partA = a.charAt(i);
			char partB = b.charAt(i);
			if(partA != partB) {
				System.out.println(partB - partA);
				break;
			}
		}

		System.out.println(b.compareTo(a));//b - a

	}
}
