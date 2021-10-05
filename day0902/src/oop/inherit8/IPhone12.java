package oop.inherit8;

public class IPhone12 extends IPhone{

	public IPhone12(String number, String color) {
		super(number, color);
	}

	public IPhone12(String color) {
		super(color);
	}

	//고유 기능
	public void faceTime() {
		System.out.println("아이폰12의 영상통화 기능 실행");
	}

	//재정의
	@Override
	public void call() {
		System.out.println("아이폰12의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰12의 문자 기능 실행");
	}

	@Override
	public void siri() {
		System.out.println("아이폰12의 음성인식 기능 실행");
	}
}
