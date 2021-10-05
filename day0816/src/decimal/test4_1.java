package decimal;

import java.lang.*;

public class test4_1 {
	public static void main(String[] args) {
//다음 시간과 관련된 계산을 수행하세요
		// 하루에 1시간 20분씩 20일간 공부했을 때의 총 공부 시간을 계산해서 출력하세요
		int hourPerDay = 1;
		int minutePerDay = 20;
		int period = 20;
		
		int totalPerDay = hourPerDay * 60 + minutePerDay; //하루의 총 시간(분)
		int totalTime = totalPerDay * period;
		int totalDay = totalTime / 60 / 24;
		int totalHour = totalTime / 60 % 24;
		int totalMinute = totalTime % 60;
		
		System.out.println(totalDay);
		System.out.println(totalHour);
		System.out.println(totalMinute);
		 
		
		
		
	}
}
