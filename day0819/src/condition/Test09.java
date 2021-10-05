package condition;

import java.lang.*;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		// 다중 조건
		// 사용자에게 생년월일 4자리를 입력받아 지하철 요금을 계산하여 출력
		// 지하철요금표
		// 어르신(65세 이상) : 무료 
		// 성인(20세 이상 65세 미만) : 1250원
		// 청소년(14세 이상 20세 미만) : 720원
		// 어린이(8세 이상 14세 미만 : 450원
		// 영유아(8세 미만) : 무료
		
		
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일 4자리를 입력하세요");
		int birth = sc.nextInt();
		sc.close();
		
		//처리
		int thisYear = 2021;
		int age = thisYear - birth +1 ;
		
		// 출력
		System.out.println("나이 : " + age + "살");

		if (age >= 20 && age <65) {
			System.out.println("요금 : 1250원");

		} else if (age >= 14 && age <20) {
			System.out.println("요금 : 720원");

		} else if (age >= 8&& age <14) {
			System.out.println("요금 : 450원");
			
		} else {//영유아 또는 어르신
			System.out.println("요금 : 0원");
		}

	}
}
