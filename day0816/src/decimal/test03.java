package decimal;

import java.lang.*;

public class test03 {
	public static void main(String[] args) {
		
		//입력(준비)
		int hour = 3, minute = 35;

		//처리 : 1시간은 60분이다
		int total = hour * 60 + minute;

		//출력(결과)
		System.out.println(total);

		//2번 문제

		//입력
		int yesterdayHour = 2 , yesterdayMinute = 50;
		int todayHour = 4 , todayMinute = 30;

		//처리1 : 사람이 푸는 방식(비추천)
		int totalHour = yesterdayHour + todayHour + (yesterdayMinute + todayMinute) / 60;
		int totalMinute = (yesterdayMinute + todayMinute) % 60;

		//출력1
		System.out.println(totalHour);
		System.out.println(totalMinute);

		//처리2 : 컴퓨터가 푸는 방식(가장 낮은 단위로 변환하여 계산 후 복원)
		int yesterdayTime = yesterdayHour * 60 + yesterdayMinute;
		int todayTime = todayHour * 60 + todayMinute;
		int totalTime = yesterdayTime + todayTime;
		int totalHour2 = totalTime / 60;
		int totalMinute2 = totalTime % 60;

		//출력2
		System.out.println(totalTime);
		System.out.println(totalHour2);
		System.out.println(totalMinute2);
				
	}
}
