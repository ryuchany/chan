package oop.inherit2;

//갤럭시 클래스는 휴대폰 클래스의 모든 내용을 "상속"받고 시작한다
public class Galaxy extends Phone {
	public void samsungPay() {
		System.out.println("삼성페이 실행");
	}
	public void voiceRecord() {
		System.out.println("통화녹음 실행");
	}
}
