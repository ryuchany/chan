package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test05_4 {
	public static void main(String[] args) {
		//Q : 객체 배열을 정렬하려면?
		Student[] list = new Student[3];

		list[0] = new Student("피카츄", 90);
		list[1] = new Student("라이츄", 75);
		list[2] = new Student("꼬부기", 80);

		//비교기준이 정의된 클래스라면 따로 언급 없이도 정렬이 가능
		Arrays.sort(list);

		for(int i=0; i < list.length; i++) {
			System.out.println("["+i+"] " + list[i]);
		}
	}
}
