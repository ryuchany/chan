package oop.method1;

public class Mart {
	
	
	String code;
	String name;
	String list;
	int price;
	
	void init(String code, String name, String list, int price) {
		this.code = code;
		this.name = name;
		this.list = list;
		this.price = price;
	}
		
	void showInfo() {
		System.out.println("<마트 상품 정보>");
		System.out.println("상품코드 : "+this.code);
		System.out.println("이름 : "+this.name);
		System.out.println("분류 : "+this.list);
		System.out.println("가격 : "+this.price+"원");
	}
		
	
}
