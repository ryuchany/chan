package oop.keyword1;

	//목표 : "이름"은 단 한번만 설정 가능하도록 구현
	//= 세터 메소드를 생성하지 말아야 하며
	//= 생성자에서 초기화를 반드시 수행
	//-> 프로그래밍 배치 등으로 구현하기는 어렵고
	//-> final 이라는 키워드를 사용하면 구현 가능!
	//-> final 변수는 "생성자"에서 반드시 초기화가 이루어져야 한다.
	public class Student {
//		private final String name = "피카츄";
		private final String name;
		private int score;

		public Student(String name) {
			this.name = name;
		}
		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

//		final 멤버변수는 setter 메소드를 가질 수 없다
//		public void setName(String name) {
//			this.name = name;
//		}
		public void setScore(int score) {
			this.score = score;
		}

		public String getName() {
			return this.name;
		}
		public int getScore() {
			return this.score;
		}

		public void showInfo() {
			System.out.println(this.name);
			System.out.println(this.score);
		}
	}
