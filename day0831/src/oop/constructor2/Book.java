package oop.constructor2;

public class Book {
	private String title;			//반드시 존재해야 하는 필수 항목
	private String publisher;	//없을 수도 있고, 있을 수도 있는 선택 항목
	private String writer;		//반드시 존재해야 하는 필수 항목
	private int price;				//없을 수도 있고, 있을 수도 있는 선택 항목

	//Q : 책을 만드는 방법은 총 몇가지인가?
	//A : 4가지 = 제목+지은이 / 제목+지은이+출판사 / 제목+지은이+가격 / 제목+지은이+출판사+가격
	//생성자가 4개 있으면 완벽하게 구현이 가능

	//기본 생성자 : 아무런 초기화도 수행하지 않는 생성자
	//public Book() {}

	public Book(String title, String writer) {//생성방법 1 : 제목 + 지은이
		this.title = title;
		this.writer = writer;
	}

	public Book(String title, String writer, String publisher) {//생성방법 2 : 제목 + 지은이 + 출판사
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
	}

	public Book(String title, String writer, int price) {//생성방법 3 : 제목 + 지은이 + 가격
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public Book(String title, String writer, String publisher, int price) {//생성방법 4 : 모든정보
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	
}
