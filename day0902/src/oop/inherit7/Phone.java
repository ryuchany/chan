package oop.inherit7;

public class Phone {
	protected String number;
	protected String color;

	public void setNumber(String number) {
		this.number = number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return this.number;
	}
	public String getColor() {
		return this.color;
	}

	public Phone(String color) {
		this(null, color);
	}
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}

	public void call() {
		System.out.println("전화 기능 실행");
	}
	public void sms() {
		System.out.println("문자 기능 실행");
	}
}
