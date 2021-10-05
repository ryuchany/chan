package condition;

import java.lang.*;
import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		//KH여행사에서는 고객을 유치시키기 위해 다음과 같은 프로모션을 진행합니다.
		//- 프로모션 내용
		//계절(봄,여름,가을,겨울) 별로 할인율을 다르게 적용시킨다.
		//봄 :10%, 여름:40%, 가을:30%, 겨울:20%
		//하루 여행 경비는 1인당 10만원으로 한다
		// 사용자에게 다음 정보를 입력받아 할인율과 할인이 적용된 예상 경비를 계산하여 출력
		//여행 갈 달의 정보를 1~12 사이의 숫자로 입력받는다.
		//여행 갈 기간의 정보를 일단위의 숫자로 입력받는다.
		
		
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("여행 갈 달을 입력 하세요 (1~12)");
		int month = sc.nextInt();
		System.out.println("여행 기간(일)을 입력 하세요");
		int day = sc.nextInt();
		sc.close();

		//처리
		int dayPrice = 100000;

		int discountRate;
		if(month == 3 || month == 4  || month == 5) { // 봄
			discountRate = 10 ;
		}
		else if(month == 6 || month == 7  || month == 8) { //여름
			discountRate = 40 ;
		}
		else if(month == 9 || month == 10  || month == 11) { //가을
			discountRate = 30 ;
		}
		else { //겨울
			discountRate = 20 ;
		}

		int beforeDiscount = day * dayPrice;
		int afterDiscount = beforeDiscount * (100 - discountRate) / 100; // 할인율
		
		//출력(결과)
		System.out.println("여행 가는 달 : " + month + "월");
		System.out.println("여행 가는 기간 : " + day + "일");	
		System.out.println("할인 전 요금 : " + beforeDiscount + "원");
		System.out.println("할인율 : "+ discountRate + "%");
		System.out.println("할인 후 요금 : " + afterDiscount + "원");

	}
}