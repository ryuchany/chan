package oop.inherit8;

public class GalaxyFold3 extends Galaxy {

	public GalaxyFold3(String number, String color) {
		super(number, color);
	}

	public GalaxyFold3(String color) {
		super(color);
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시 폴드3의 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시 폴드3의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시 폴드3의 전화 기능 실행");
	}

	public void iris() {
		System.out.println("갤럭시 폴드3의 홍채인식 기능 실행");
	}
}
