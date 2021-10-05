package decimal;

import java.lang.*;

public class test05 {
	public static void main(String[] args) {
		
		//입력(준비)
		int inHour = 7, inMinute = 50;
		int outHour = 9, outMinute = 15;
		int pricePerHour = 600;
		
		// 처리

		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		
		int hour = time / 60;
		int minute = time % 60;
		
		int pricePerMinute = pricePerHour / 60;
		int totalPrice = time * pricePerMinute;
		
		//출력(결과)
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(totalPrice);

	}
}
