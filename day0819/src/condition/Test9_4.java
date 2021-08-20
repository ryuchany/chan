package condition;

import java.lang.*;
import java.util.Scanner;

public class Test9_4 {
	public static void main(String[] args) {
		// 다중 조건
		// 사용자에게 생년월일 4자리를 입력받아 지하철 요금을 계산하여 출력
		// 지하철요금표
		// 어르신(65세 이상) : 무료
		// 성인(20세 이상 65세 미만) : 1250원
		// 청소년(14세 이상 20세 미만) : 720원
		// 어린이(8세 이상 14세 미만 : 450원
		// 영유아(8세 미만) : 무료

		//입력(준비)
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리 입력");
		int birth = sc.nextInt();
		sc.close();

		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;

		int price;
		if(age < 8 || age >= 65) {//영유아 또는 어르신이라면
			price = 0;
		}
		else if(age >= 20) {//성인이라면
			price = 1250;
		}
		else if(age >= 14) {//청소년이라면
			price = 720;
		}
		else {//어린이라면
			price = 450;
		}

		//카드 보증금 500원 추가
		price = price + 0;

		//출력(결과)
		System.out.println("나이 : " + age);
		System.out.println("요금 : " + price + "원");

	}
}