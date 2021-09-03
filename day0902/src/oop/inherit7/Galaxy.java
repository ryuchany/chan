package oop.inherit7;

public class Galaxy extends Phone{

	public Galaxy(String color) {
		super(color);
	}

	public Galaxy(String number, String color) {
		super(number, color);
	}

	public void samsungPay() {
		System.out.println("삼성페이 기능 실행");
	}

}