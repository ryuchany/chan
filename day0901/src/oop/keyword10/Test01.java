package oop.keyword10;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {

		// Q. 랜덤으로 가위바위보 중 하나를 출력
		// = 랜덤으로는 정수를 추첨할 수 있다.
		// = 문자열은 어떻게?

		Random r = new Random();
		int com = r.nextInt(3) + 1; // 1부터 3개

		// System.out.println("com = " + com);

		switch (com) {
		case 1:
			System.out.println("가위!");
			break;
		case 2:
			System.out.println("바위!");
			break;
		case 3:
			System.out.println("보!");
			break;
		}
	}
}