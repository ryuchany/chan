package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test04_1 {
	public static void main(String[] args) {

		//입력
		int year = 2021;
		int month = 9;

		//계산
		//1. Calendar 생성
		//2. 입력값에 있는 연도와 월, 1일로 달력을 설정
		//3. 해당 월의 1일의 요일을 계산
		//4. 3번에서 계산한 날짜 바로 직전의 일요일 날짜를 구해야 한다(달력은 일요일부터 출력되기 때문)

		//1
		Calendar c = Calendar.getInstance();

		//2
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);//주의 : 월은 0~11로 관리되므로 1 작게 넣어야 한다
		c.set(Calendar.DATE, 1);

		//3
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일 = " +dayOfWeek);

		//4
		int beforeDays = dayOfWeek - 1;//뒤로 이동해야할 날짜
		c.add(Calendar.DATE, -beforeDays);

		//출력
		for(int i=0; i < 42; i++) {		
			Format f = new SimpleDateFormat("y년 M월 d일 E");
			System.out.println(f.format(c.getTime()));

			c.add(Calendar.DATE, 1);//다음날로 설정
		}
	}
}
