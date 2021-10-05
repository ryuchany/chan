package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {

		int count = 100;

		Calendar c = Calendar.getInstance();

		c.set(2021, Calendar.DECEMBER, 25);// 2021-12-25

		c.add(Calendar.DATE, -count + 1);// 100일 전

		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(count + "일 전 날짜는 : " + f.format(d));

	}
}
