package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {

		// 1. 인원수 설정
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 설정 : ");
		int size = sc.nextInt();
		sc.nextLine();// 엔터 제거

		if (size < 2 || size > 24) {
			System.err.println("인원을 2명 이상 24명 이하로 설정하세요");
			System.exit(-1);// 비정상종료
		}

		// 2. 이름 입력 및 항목 입력
		List<String> names = new ArrayList<>(size);
		List<String> events = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			names.add(name);
		}

		for (int i = 0; i < size; i++) {
			System.out.print("항목 입력 : ");
			String event = sc.nextLine();
			events.add(event);
		}
		sc.close();

		Collections.shuffle(events);

		for (int i = 0; i < size; i++) {
			System.out.print(names.get(i));
			System.out.print(" → ");
			System.out.print(events.get(i));
			System.out.println();
		}

	}
}
