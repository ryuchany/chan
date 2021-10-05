package total;
import java.lang.*;
public class test01 {
	public static void main(String[] args) {

		//입력
		int inHour = 12, inMinute = 34; // 입장시간
		int outHour = 15, outMinute = 21; // 퇴장시간
		int price = 500; //10분당 주차 요금
		int pirceTime = 10;; /// 요금 분 기준
		
		//처리
		int inTime = inHour * 60 + inMinute; // 입장시간 분리
		int outTime = outHour * 60 + outMinute; //퇴장시간 분리
		int time = outTime - inTime; // 총 주차 시간
		
		int hour = time / 60; // 시간 으로 표시
		int minute = time % 60; // 분 으로 표시
		int totalTime = (hour * 60) + minute; // 시간 + 분 = 분으로 표시
		
		int totalPrice = price*(totalTime/pirceTime); // 주차 요금 계산

		boolean Discount = hour >= 2; // 2시간 이상 주차 할인 대상
		
		//출력(결과)
		System.out.println("총 주차 시간 = " + hour+"시간 " + minute+"분");
		System.out.println("총 주차 요금 = " + totalPrice + "원");
		System.out.println("할인 대상 = " + Discount);
		//System.out.println("할인 후 요금 = " + "?" + "원");
		
	}
}
