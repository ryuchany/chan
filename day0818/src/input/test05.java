package input;
import java.lang.*;
import java.util.Scanner;
public class test05 {
	public static void main(String[] args) {
		//과거에 만들었던 PC방 프로그램에 입력기능 더해서 다음 요구사항에 맞게 구현
		//- 입력정보 
		//- 시작 시각, - 종료 시각
		//- 처리
		// - 이용 요금 : 1시간 당  1000원
		//- 결과
		//-이용시간, - 계산된 이용요금(원)
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("시작 시각을 입력하세요");
		int inHour = sc.nextInt();
		int inMinute = sc.nextInt();
		
		System.out.println("종료 시각을 입력하세요");
		int outHour = sc.nextInt();
		int outMinute = sc.nextInt();
		
		sc.close();
		
		int price = 1000;

		//처리
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		
		int hour = time / 60;
		int minute = time % 60;
		
		int pricePerMinute = price / 60;
		int totalPrice = time * pricePerMinute;
		totalPrice = totalPrice / 100 * 100; // 버림
		// totalPrice = (totalPrice + 50) / 100 * 100; // 반올림
		// totalPrice = (totalPrice + 99) / 100 * 100; // 올림
		
		//출력
		System.out.println("이용 시간 : " + hour + "시간 " +minute+ "분" );
		System.out.println("이용 요금 : " + totalPrice + "원" );
	}
}
