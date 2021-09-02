package oop.inherit1;

//갤럭시 클래스
public class Galaxy {
	// 멤버변수
	private String number;

	// 멤버 메소드
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void call() {
		System.out.println("전화 기능 실행!");
	}
	public void sms() {
		System.out.println("문자 기능 실행!");
	}
	public void gallery() {
		System.out.println("갤러리 실행!");
	}
	public void samsungPay() {
		System.out.println("삼성페이 실행");
	}
	public void voiceRecord() {
		System.out.println("통화녹음 실행");
	}
}








