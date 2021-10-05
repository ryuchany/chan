package oop.basic3;

public class Player {
	// 멤버 변수 - 데이터 저장 공간

	String name;
	String type;
	int gold;
	int silver;
	int bronze;

	// 멤버 메소드 - 코드 저장 공간
	// void 이름(){ 코드 }
	void init(String name, String type, int gold, int silver, int bronze) {
		this.name = name;
		this.type = type;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	void showInfo() {
		// a, b, c같은 특정 대상이 아니라 "주인공"을 의미하는 키워드를 사용
		// = this
		System.out.println("<선수 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("종목 : " + this.type);
		System.out.println("금메달 : " + this.gold);
		System.out.println("은메달 : " + this.silver);
		System.out.println("동메달 : " + this.bronze);
	}

}
