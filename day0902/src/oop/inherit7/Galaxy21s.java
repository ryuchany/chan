package oop.inherit7;

public class Galaxy21s extends Galaxy {

	public Galaxy21s(String color) {
		super(color);
	}

	public Galaxy21s(String number, String color) {
		super(number, color);
	}

	// 고유기능
	public void bixby() {
		System.out.println("갤럭시21s의 음성인식 기능 실행");
	}

	// 마음에 들지 않는 기능들을 재정의
	@Override
	public void call() {
		System.out.println("갤럭시21s의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시21s의 문자 기능 실행");
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시21s의 삼성페이 기능 실행");
	}
}
