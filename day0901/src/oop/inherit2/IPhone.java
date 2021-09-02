package oop.inherit2;

//아이폰 클래스는 휴대폰 클래스의 모든 내용을 "상속"받고 시작한다
public class IPhone extends Phone {
	public void itunes() {
		System.out.println("아이튠즈 실행");
	}
	public void siri() {
		System.out.println("음성인식 실행");
	}
}
