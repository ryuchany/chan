package oop.keyword1;

public class Test01 {

	public static void main(String[] args) {
		Student s = new Student("손오공", 90);

//		s.setName("저팔계");//불가능(안만들어짐)
		s.setScore(50);

		s.showInfo();
	}
}
