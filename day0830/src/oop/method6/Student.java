package oop.method6;

public class Student {

	// 멤버 변수
	String name;
	int grade;
	int korean;
	int english;
	int math;
	String raking;

	// 세터 메소드
	void setName(String name) {
		this.name = name;
	}

	void setGrade(int grade) {
		if (grade >= 1 && grade <= 3) {
		this.grade = grade;
		}
	}

	void setKorean(int korean) {
		if (korean >= 0 && korean <= 100) {
			this.korean = korean;
		}
	}

	void setEnglish(int english) {
		if (english >= 0 && english <= 100) {
			this.english = english;
		}
	}

	void setMath(int math) {
		if (math >= 0 && math <= 100) {
			this.math = math;
		}
	}

	// 게터 메소드
	String getName() {
		return this.name;
	}

	int getGrade() {
		return this.grade;
	}

	int getKorean() {
		return this.korean;
	}

	int getEnglish() {
		return this.english;
	}

	int getMath() {
		return this.math;
	}

	int getTotal() {
		return this.korean + this.english + this.math;
	}

	float getAverage() {
		return this.getTotal() / 3.0f;
	}

	String getRaking() {
		if (this.getAverage() >= 90 && this.getAverage() <= 100) {
			return "A";
		} else if (80 <= this.getAverage() && this.getAverage() < 90) {
			return "B";
		} else if (70 <= this.getAverage() && this.getAverage() < 80) {
			return "C";
		} else {
			return "F";
		}
	}

	// 멤버 메소드
	void init(String name, int grade, int korean, int english, int math) {
		this.setName(name);
		this.setGrade(grade);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}

	// 출력 정보
	void showInfo() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("학년 : " + this.grade);
		System.out.println("국어점수 : " + this.korean + "점");
		System.out.println("영어점수 : " + this.english + "점");
		System.out.println("수학점수 : " + this.math + "점");
		System.out.println("총점 : " + this.getTotal() + "점");
		System.out.println("평균 : " + this.getAverage() + "점");
		System.out.println("등급 : " + this.getRaking() + "등급");

	}
}
