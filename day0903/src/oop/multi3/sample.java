package oop.multi3;

//인터페이스의 구조
//= 인터페이스도 클래스의 한 종류이다.
//= 클래스의 구성요소들 중 가질 수 있는 것과 없는 것이 있다.
//= 다중상속에서의 부모 클래스가 목적이기 때문에 "모호함"을 발생시키는 요소들이 전부다 제거되었다.
//= 결론 : 인터페이스는 "상수"와 "추상메소드"를 가질 수 있다.
public interface sample {
	// 멤버 변수 : 생성 불가. 오로지 상수만 정의할 수 있다. 안써도 자동생성
	public static final int a = 10;
	/* public static final */ int b = 20; // 안써도 자동 생성

	// 멤버 메소드 : 일반 메소드는 불가. 추상 메소드만 가능. 안써도 자동생성
	/* public abstract */ void showInfo(); // 안써도 자동 생성

	// 생성자 : 생성자는 가질 수 없다(super 사용 방지 차원)
	// public Sample(){}
}
