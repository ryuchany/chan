package oop.method4;

public class Student {
	// 멤버 변수 - 데이터

	String name;
	String subject;
	int score; // 서술형 시험 점수
	int checkScore; // 체크리스트 시험 점수

	// 멤버 메소드 - 코드(기능)
	// - 세터 메소드 4개 - setName, setSubject, setScore, setCheckScore
	// - init 메소드
	// - showInfo 메소드

	void setName(String name) {
		this.name = name;
	}

	void setSubject(String subject) {
		this.subject = subject;
	}

	void setScore(int score) {
		if (score >= 0 && score <= 100) { // 올바른 점수(0~100)라면
			this.score = score;
		}
	}

	void setCheckScore(int checkScore) {
		if (checkScore <= 0 && checkScore >= 100) { // 잘못된 점수(0미만 100초과)라면
			return;// 메소드 실행을 중지하는 키워드
		}
		this.checkScore = checkScore;
	}

	void init(String name, String subject, int score, int checkScore) {
		this.setName(name);
		this.setSubject(subject);
		this.setScore(score);
		this.setCheckScore(checkScore);
	}

	void showInfo() {
		System.out.println("<우리반 성적 정보>");

		// 일반 정보들은 멤버 변수로 관리해야 한다.
		// =학생의 고유정보이기 때문
		System.out.println("이름 : " + this.name);
		System.out.println("과목 : " + this.subject);
		System.out.println("서술형점수 : " + this.score + "점");
		System.out.println("평가자체크리스트점수 : " + this.checkScore + "점");

		// 합계, 평균, 합격/불합격 정보등은 그때그때 계산해야하는 정보이다.
		// = 변경되는 점수가 반영되어야 하기 때문!
		int total = this.score + this.checkScore;
		float average = total / 2.0f;
		System.out.println("평균점수 : " + average + "점");

		boolean isPass = average >= 60 && this.score >= 40 && this.checkScore >= 40;
		if (isPass) {
			System.out.println("해당 시험에 통과하였습니다");
		} else {
			System.out.println("해당 시험 재평가 응시 대상자입니다");
		}
	}

}
