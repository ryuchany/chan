package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
		// 시간의 형식(Format)을 변경하여 출력
		// = 자바는 형식마저도 객체 형태로 제공한다?(java.text.SimpleDateFormat)
		// = 형식 객체를 만들고, 형식 객체의 메소드를 이용하여 시간 객체의 설정을 변경한다.

		Date a = new Date();

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		String time = f.format(a);

		System.out.println(time);

	}
}
