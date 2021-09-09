package api.util.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		Date d = new Date();

		// 업캐스팅 사용

//		2021-09-08 15:36:32
		Format f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f1.format(d));

//		2021년 9월 8일 수
//		Format f2 = new SimpleDateFormat("y년 MMM d일 EEEE");
		Format f2 = new SimpleDateFormat("y년 M월 d일 E요일");
		System.out.println(f2.format(d));

//		오후 3시 36분 32초
		Format f3 = new SimpleDateFormat("a h시 m분 s초");
		System.out.println(f3.format(d));
	}
}
