package decimal;

import java.lang.*;

public class test06 {
	public static void main(String[] args) {

//다음과 같은 숫자가 주어져 있을 때, 숫자를 계산(변형)하여 한국 나이를 계산하여 출력
//(생년, 월, 일 정보도 같이 출력)

		// 입력
		int birth = 19990101;

		// 처리
		int year = birth / 10000; 
		int month = birth % 10000 / 100;
		int day = birth % 10000 %100;
		int today = 2021;
		int age = 1 + today - year;

		// 결과
		System.out.println(year+"년");
		System.out.println(month + "월 ");
		System.out.println(day + "일");
		System.out.println(age +"세");
		
	}
}
