package oop.inherit8;

//추상 클래스를 상속받는 경우 상속된 추상 메소드를 반드시 완성시켜야 한다
public class Galaxy21s extends Galaxy {

	public Galaxy21s(String number, String color) {
		super(number, color);
	}

	public Galaxy21s(String color) {
		super(color);
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시21s의 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시21s의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시21s의 문자 기능 실행");
	}

	public void bixby() {
		System.out.println("갤럭시21s의 빅스비 기능 실행");
	}

}
