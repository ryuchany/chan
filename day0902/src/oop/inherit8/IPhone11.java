package oop.inherit8;

public class IPhone11 extends IPhone {

	public IPhone11(String number, String color) {
		super(number, color);
	}

	public IPhone11(String color) {
		super(color);
	}

	@Override
	public void siri() {
		System.out.println("아이폰11의 음성인식 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰11의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰11의 문자 기능 실행");
	}

	public void itunes() {
		System.out.println("아이폰11의 아이튠즈 기능 실행");
	}

}
