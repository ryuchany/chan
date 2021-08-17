package realnumber;

import java.lang.*;

public class test03 {
	public static void main(String[] args) {
		//고급 레스토랑에서 커플 스테이크 세트를 159000원에 주문하여 먹었습니다.
		//제휴카드를 사용하여 30% 할인을 받았습니다
		//할인 후 금액을 구하여 출력하세요.
		
		//입력
		int price = 159000; //결제금액
		int rate = 30; //할인율
		
		//처리
		int result = price * (100-rate) /100; // 강제 변환 (double을 int에 딱 맞게 강제로 변환)
		//int result = price / 100 * (100*rate); 
		//나누기를 먼저하면 손실 발생 가능성 있음
				
		//출력		
		System.out.println(result + "원");
		
	}
}
