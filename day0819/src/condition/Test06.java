package condition;

import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		// 다중 조건
		// 나이에 따라 10대, 20대, 30대, 기타로 구분하는 프로그램

		// 입력
		int age = 20;

		// 출력
		if (age >= 10 && age < 20) {
			System.out.println("당신은 10대입니다");
		}
		if (age >= 20 && age < 30) {
			System.out.println("당신은 20대입니다");
		}
		if (age >= 30 && age < 40) {
			System.out.println("당신은 30대입니다");
		}
		if (age < 10 || age >= 40) {
			System.out.println("당신은 해당 대상이 아닙니다");
		}
	}
}
