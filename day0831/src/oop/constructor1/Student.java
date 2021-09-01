package oop.constructor1;

public class Student {
	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//생성자(Contstructor)
	//= 객체의 생성방식을 결정하는 구문
	//= 없으면 기본 생성방식을 지원
	//= 메소드의 변형(메소드와 형태가 다름)
	//= 객체 생성 시 딱 한 번만 실행
	//= 클래스랑 이름이 반드시 같아야 함
	//= 반환형을 적을 수 없고 오로지 초기화만 가능
	public Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	public void showInfo() {
		System.out.println(this.name);
		System.out.println(this.score);
	}
	
}
