package oop.modifier2;

public class Test01 {

	public static void main(String[] args) {

		Phone a = new Phone();
		Phone b = new Phone();
		Phone c = new Phone();

		// 초기화
		a.init("갤럭시폴드3", "SKT", 24, 2000000);
		b.init("아이폰12", "KT", 24, 1800000);
		c.init("갤럭시21s", "LGuplus", 30, 1550000);

		// 출력
		a.showInfo();
		b.showInfo();
		c.showInfo();

	}

}
