package oop.method6;

public class Test01 {

	public static void main(String[] args) {

		// 생성
		Student a = new Student();
		Student b = new Student();
		Student c = new Student();

		// 초기화
		a.init("마리오", 1, 90, 80, 70);
		b.init("루이지", 1, 85, 85, 83);
		c.init("쿠파", 3, 70, 60, 55);

		// 테스트
		//a.setGrade(5);
		// a.setMath(-1);
		// b.setMath(101);
		// c.setMath(100);

		// 출력
		a.showInfo();
		b.showInfo();
		c.showInfo();

	}
}
