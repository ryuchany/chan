package api.util.date;

import java.util.Date;

public class Test02 {
	public static void main(String[] args) {

		// Date 클래스를 이용하여 현재 날짜를 출력
		Date a = new Date();
		System.out.println(a);

		// 비추천된 생성자가 많은 이유
		Date b = new Date(2020, 9, 8);
		System.out.println(b);
	}
}
