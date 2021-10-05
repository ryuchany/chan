package oop.inherit1;

//아이폰 클래스
public class IPhone {
	// 멤버 변수
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
	public void itunes() {
		System.out.println("아이튠즈 실행");
	}
	public void siri() {
		System.out.println("음성인식 실행");
	}
}






