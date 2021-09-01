package oop.constructor3;

public class Test01 {

	public static void main(String[] args) {

		User a = new User("뽀로로", "전사", 50, 50000);
		User b = new User("크롱", "마법사", 35, 20000);
		User c = new User("루피", "전사");

		a.showInfo();
		b.showInfo();
		c.showInfo();

		// Getter가 없으면 풀 수 없는 상황
		// a와 b의 레벨 차이를 구하여 출력하세요
		// System.out.println(a.level - b.level);
		System.out.println(a.getLevel() - b.getLevel());
	}
}
