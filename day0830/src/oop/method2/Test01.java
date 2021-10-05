package oop.method2;

public class Test01 {

	public static void main(String[] args) {
		// 생성
		Menu a = new Menu();
		Menu b = new Menu();
		Menu c = new Menu();
		Menu d = new Menu();

		// 초기화 - init 메소드 호출 = 값을 설정하는 코드
		a.init("아메리카노", "음료", 2000, true);
		b.init("프라포치노", "음료", 3500);
		c.init("치즈케이크", "빵", 5000, true);
		d.init("유기농샌드위치", "빵", 3000);

		// 출력 - showInfo 메소드 호출 = 출력 값을 화면에 표시하는 코드
		a.showInfo();
		b.showInfo();
		c.showInfo();
		d.showInfo();

	}

}
