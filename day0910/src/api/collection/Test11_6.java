package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test11_6 {
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
			} else {
				// 검색 및 투표
			}
		}
		sc.close();

		// 출력
		System.out.println("투표가 완료되었습니다");
		for (Artist art : list) {
			System.out.print("[");
			System.out.print(art.getName());
			System.out.print("-");
			System.out.print(art.getPosition());
			System.out.print("]");
			System.out.print(" ");
			System.out.print("득표수 : ");
			System.out.print(art.getCount());
			System.out.println();
		}

	}
}
