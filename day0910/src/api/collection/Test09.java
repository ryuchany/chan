package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test09 {
	public static void main(String[] args) {
		// 학생을 저장할 List 구현

		// List 생성
		List<Student> list = new ArrayList<>();

		// 데이터 추가 - add()
		// list.add("피카츄", 50);//String, int --> error
		list.add(new Student("피카츄", 50));// Student
		list.add(new Student("라이츄", 70));
		list.add(new Student("파이리", 85));

		// 출력
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(s.getName() + ", " + s.getScore());
		}

		for (Student s : list) {
			System.out.println(s.getName() + ", " + s.getScore());
		}

		// 개수확인
		System.out.println(list.size());

		// 검색
		// = 우리가 만든 클래스는 동등 비교가 정의되어 있지 않다.
		// = 반복문을 통해서 이름이나 점수등을 비교하든가
		// = 동등비교(equals)를 정의하면 된다.
		System.out.println(list.contains("피카츄"));
		System.out.println(list.contains(new Student("피카츄", 50)));

		System.out.println(list.indexOf(new Student("피카츄", 50)));

		// 삭제
		// = index를 이용하여 삭제하는 방법은 가능하다.
		// = 데이터를 이용하여 삭제하려면 동등비교(equals) 정의가 필요
		list.remove(new Student("피카츄", 50));
		list.remove(1);

		System.out.println(list.size());
	}
}
