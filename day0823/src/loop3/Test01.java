package loop3;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//do~while 반복
		//= 선 실행(do) 후 반복(while)을 수행하는 구문
		//같은 구문에서 변수가 공유가 되지 않음
		// 중괄호와 세미콜론을 동시에 사용하는 등 문법적으로 요구사항이 많음
		
		//ex : 사용자에게 점수(1~100점)를 입력받는 코드 구현. 잘못 입력하면 다시 입력하도록 처리
		Scanner sc = new Scanner(System.in);;
		
		int score;
		do {
			//점수를 입력받는 코드
			System.out.println("점수 입력");
			score = sc.nextInt();
		}
		while(!(score >=0 && score <= 100));//점수를 다시 입력받는 조건 : 점수를 잘못 입력하면(0이상 100이하가 아니라면 / 0미만 또는 100초과)

		sc.close();
	}
}
