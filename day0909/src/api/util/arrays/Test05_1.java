package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test05_1 {
	public static void main(String[] args) {
		//Q : 객체 배열을 정렬하려면?
		Student[] list = new Student[3];

		list[0] = new Student("피카츄", 90);
		list[1] = new Student("라이츄", 75);
		list[2] = new Student("꼬부기", 80);

		//학생(Student) 비교 기준
		//1차 기준 : 이름 오름차순
		//2차 기준 : 점수 내림차순
		Comparator<Student> c = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getName().equals(o2.getName())) {
					return o2.getScore() - o1.getScore();
				}
				else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		};

		Arrays.sort(list, c);

		for(int i=0; i < list.length; i++) {
			System.out.println("["+i+"] " + list[i]);
		}
	}
}
