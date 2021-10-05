package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test11_7 {
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
				// 1. 비어있는 리모컨을 준비
				Artist find = null;

				// 2. 반복문을 통해 리스트의 데이터를 직접 탐색하여 있으면 리모컨에 정보 설정
				for (int i = 0; i < list.size(); i++) {
					Artist art = list.get(i);
					if (art.getName().equals(name)) {// i번 위치의 Artist 이름이 name과 같다면
						find = art;// find에 찾은 객체 정보를 전달하라
						break;// 찾으면 그만(성능 향상)
					}
				}

				// 3. 검색 여부에 따라 다른 메세지를 준비하고, 검색 결과가 있으면 투표처리
				if (find != null) {// 검색 결과가 있으면
					find.vote();
					System.out.println("[" + find.getName() + "] 투표가 완료되었습니다");
				} else {// 검색 결과가 없으면
					System.out.println("찾으시는 이름의 후보가 없습니다");
				}
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
