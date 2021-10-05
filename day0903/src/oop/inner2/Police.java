package oop.inner2;

public class Police { // 외부 클래스
	private Gun gun; // 멤버 변수

	public Gun getGun() { // 멤버 메소드
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	// 경찰만이 권총을 사용할 수 있도록
	// = 경찰 클래스 내부에 권총 클래스를 구현
	// = 경찰 외부에서는 Gun이 있느지 알 수 없음
	private class Gun { // 멤버 클래스 // 내부or 중첩 클래스
		// 클래스이므로 이 안에 구성요소를 모두 가질 것
		// = 멤버 변수, 메소드, 생성자, 중첩클래스
	}

}
