package oop.constructor2;

public class Test01 {

	public static void main(String[] args) {
		// Book 객체 생성
		// Book a = new Book();//불가능. 허락하지 않는 생성방식
		Book a = new Book("생각을 바꾸는 생각들", "비카스 샤");// 제목 + 지은이
		Book b = new Book("소크라테스 익스프레스", "에릭 와이너", 16200);// 제목 + 지은이 + 가격
		Book c = new Book("전기차 상식사전", "정우덕", "넥서스 BOOKS");// 제목 + 지은이 + 출판사
		Book d = new Book("전기기능사 필기", "김영언, 박진영", "모아팩토리", 22500);// 제목 + 지은이 + 출판사 + 가격

	}
}