package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		// Calendar 형태의 날짜 정보를 Date로 변환할 수 있는가?
		// ---> 가능하다

		Calendar c = Calendar.getInstance();

		c.set(2021, Calendar.DECEMBER, 31);// 2021-12-31

//		c에 설정된 날짜를 10일 뒤로 변경(10분 뒤, 10시간 뒤, 10달 뒤, 10년 뒤)
//		c.add(Calendar.DATE, 10);//10일 뒤
		c.add(Calendar.MONTH, 10);// 10달 뒤

		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(d));
	}
}
