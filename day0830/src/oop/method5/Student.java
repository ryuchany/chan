package oop.method5;

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

//	원하는 정보를 원하는 형태로 반환하는 메소드
//	= Getter 메소드(게터 메소드)
//	= Setter 메소드처럼 이름을 짓고, Setter 메소드 처럼 변수당 1개씩은 기본적으로 생성
//	= 필요하다면 추가적으로 더 생성할 수도 있다
//	= ex : name의 getter 메소드는 getName이다
//	= return 은 메소드를 중지하는 키워드이며, 우측에 값이 있으면 해당 값을 "호출자"에게 반환
//	= void는 실행 후 반환할 데이터가 없다는 뜻이다(null과 구분할 줄 알아야함)
	
	String getName() {
		return this.name; // 주인공(this)의 이름을 부른 대상에게 반환하세요
	}

	String getSubject() {
		return this.subject;
	}

	int getScore() {
		return this.score;
	}

	int getCheckScore() {
		return this.checkScore;
	}

	int getTotal() {
		return this.score + this.checkScore;
	}

	float getAverage() {
		// return (this.score+this.checkScore)/2.0f;
		return this.getTotal() / 2.0f;
	}

	boolean getPass() {
		return this.score >= 40 && this.checkScore >= 40 && this.getAverage() >= 60;
	}

	void showInfo() {
		System.out.println("<우리반 성적 정보>");

		// 일반 정보들은 멤버 변수로 관리해야 한다.
		// =학생의 고유정보이기 때문
		System.out.println("이름 : " + this.name);
		System.out.println("과목 : " + this.subject);
		System.out.println("서술형점수 : " + this.score + "점");
		System.out.println("평가자체크리스트점수 : " + this.checkScore + "점");

		System.out.println("평균점수 : " + this.getAverage() + "점");

		if (this.getPass()) {
			System.out.println("해당 시험에 통과하였습니다");
		} else {
			System.out.println("해당 시험 재평가 응시 대상자입니다");
		}
	}

}
