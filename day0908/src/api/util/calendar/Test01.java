package api.util.calendar;

import java.util.Calendar;

public class Test01 {
	public static void main(String[] args) {
//		Calendar 클래스를 이용한 날짜 제어
//		= 추상 클래스이며 생성자가 protected이므로 객체 생성이 불가능

//		Calendar c = new Calendar();//오류 발생
		Calendar c = Calendar.getInstance();// 생성 메소드를 이용해야함

//		System.out.println(c);

//		시각 정보 변경
//		c.set(무엇을, 얼마로);
//		c.set(Calendar.YEAR, 2021);//연도를 2050으로 설정
//		c.set(Calendar.MONTH, 9);//월을 10으로 설정(실제보다 1 작게 설정해야함)
//		c.set(Calendar.MONTH, Calendar.OCTOBER);
//		c.set(Calendar.DATE, 1);//일을 1로 설정
//		c.set(Calendar.DAY_OF_MONTH, 1);//일을 1로 설정

//		설정된 시각 정보 추출
		System.out.println("YEAR = " + c.get(Calendar.YEAR));// 연도
		System.out.println("MONTH = " + c.get(Calendar.MONTH));// 월(0부터 11까지이므로 실제보다 1 작게 나옴)
		System.out.println("DATE = " + c.get(Calendar.DATE));// 일
		System.out.println("DAY_OF_MONTH = " + c.get(Calendar.DAY_OF_MONTH));// 일

		System.out.println("HOUR = " + c.get(Calendar.HOUR));// 시간(12시간방식)
		System.out.println("HOUR_OF_DAY = " + c.get(Calendar.HOUR_OF_DAY));// 시간(24시간방식)
		System.out.println("MINUTE = " + c.get(Calendar.MINUTE));// 분
		System.out.println("SECOND = " + c.get(Calendar.SECOND));// 초
		System.out.println("MILLISECOND = " + c.get(Calendar.MILLISECOND));// 밀리초

		System.out.println("DAY_OF_WEEK = " + c.get(Calendar.DAY_OF_WEEK));// 요일
		System.out.println("AM_PM = " + c.get(Calendar.AM_PM));// 오전(0)/오후(1)
	}
}
