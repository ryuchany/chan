package oop.inherit7;

public class IPhone11 extends IPhone{

	public IPhone11(String number, String color) {
		super(number, color);
	}

	public IPhone11(String color) {
		super(color);
	}

	//고유 기능
	public void itunes() {
		System.out.println("아이폰11의 아이튠즈 기능 실행");
	}

	//마음에 들지 않는 기능들에 대한 재정의 수행
	@Override
	public void call() {
		System.out.println("아이폰11의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰11의 문자 기능 실행");
	}

	@Override
	public void siri() {
		System.out.println("아이폰11의 음성인식 기능 실행");
	}

}
