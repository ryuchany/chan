package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test11_5 {
	public static void main(String[] args) {
		// 저장되어있는 아티스트들을 "이름"으로 찾는 프로그램
		List<Artist> list = new ArrayList<>();

		// 추가
		list.add(new Artist("녹두", "보컬"));
		list.add(new Artist("대니구", "바이올린"));
		list.add(new Artist("제이유나", "보컬"));
		list.add(new Artist("박다울", "거문고"));
		list.add(new Artist("황린", "일렉기타"));

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("투표할 이름 : ");
			String name = sc.nextLine();

//			if(name == "그만") {//안됨
			if (name.equals("그만")) {
				break;
			}
		}
		sc.close();

		System.out.println("투표가 완료되었습니다");

	}
}
