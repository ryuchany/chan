package oop.inherit7;

public class IPhone extends Phone{

	public IPhone(String color) {
		super(color);
	}

	public IPhone(String number, String color) {
		super(number, color);
	}

	public void siri() {
		System.out.println("음성 인식 기능 실행");
	}

}
