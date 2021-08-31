package oop.method2;

public class Menu {

	String name;
	String list;
	int price;
	boolean isEvent;

	// 멤버 메소드
	// init 메소드는 2가지 버전으로 만들면 어떨까?
	// 1. 이름, 분류, 가격만 전달받으면 행사중이 아닌 상품으로 결정
	// 2. 이름,분류, 가격, 행사여부까지 전달받으면 정보를 그대로 설정
	// --->메소드 오버로딩 (Method Overloading )

	void init(String name, String list, int price) {
		this.name = name;
		this.list = list;
		this.price = price;
		// this.isEvent = price;
	}

	void init(String name, String list, int price, boolean isEvent) {
		this.name = name;
		this.list = list;
		this.price = price;
		this.isEvent = isEvent;
		// this.ise
	}

	void showInfo() {
		System.out.println("<커피숍 메뉴 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("종류 : " + this.list);
		// System.out.println("가격 : "+this.price+"원");
		// System.out.println("행사여부 : "+ this.isEvent);

		if (this.isEvent) {// 행사 중일때 --> 20% 할인(즉석에서 계산하여 출력)
			int discount = this.price * (100 - 20) / 100;
			System.out.println("가격 : " + discount + "원" + "(원가 : " + this.price + "원) ");

		} else {// 행사중이 아닐 때
			System.out.println("가격 : " + this.price + "원");
		}
	}
}
