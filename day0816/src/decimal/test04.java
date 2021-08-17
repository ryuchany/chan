package decimal;

import java.lang.*;

public class test04 {
	public static void main(String[] args) {

		//입력
		int hourPerDay = 1;
		int minutePerDay = 30;
		int period = 20;
		
		//처리
		int totalPerDay = hourPerDay * 60 + minutePerDay; //하루의 총 시간(분)
		int totalTime = totalPerDay * period;
		int totalHour = totalTime / 60;
		int totalMinute = totalTime % 60;
		
		//출력
		System.out.println(totalHour);
		System.out.println(totalMinute);
		 
	}
}
