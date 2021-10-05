package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test11_9 {
	public static void main(String[] args) {
		//저장되어있는 아티스트들을 "이름"으로 찾는 프로그램
		List<Artist> list = new ArrayList<>();

		//추가
		list.add(new Artist("녹두", "보컬"));
		list.add(new Artist("대니구", "바이올린"));
		list.add(new Artist("제이유나", "보컬"));
		list.add(new Artist("박다울", "거문고"));
		list.add(new Artist("황린", "일렉기타"));

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("투표할 이름 : ");
			String name = sc.nextLine();

//			if(name == "그만") {//안됨
			if(name.equals("그만")) {
				break;
			}
			else {
				//검색 및 투표
				//= hashCode와 equals 설정되어 있으므로
				//= indexOf로 위치를 찾아서 확인 가능

				//int index = list.indexOf(name);//이름으론 안됨
				Artist art = new Artist(name);
				int index = list.indexOf(art);

				if(index >= 0) {//검색 결과가 있으면
					Artist find = list.get(index);
					find.vote();
					System.out.println("["+find.getName()+"] 투표가 완료되었습니다");
				}
				else {//검색 결과가 없으면
					System.out.println("찾으시는 이름의 후보가 없습니다");
				}
			}
		}
		sc.close();

		//투표수 순으로 정렬(투표수가 같으면 이름순 정렬)
		Comparator<Artist> c = new Comparator<Artist>() {
			@Override
			public int compare(Artist a, Artist b) {
				if(a.getCount() == b.getCount()) {//투표수가 같으면
					return a.getName().compareTo(b.getName());//이름 오름차순
				}
				else {//투표수가 다르면
					return b.getCount() - a.getCount();//투표수 내림차순
				}
			}
		};
		Collections.sort(list, c);

		//출력
		System.out.println("투표가 완료되었습니다");
		for(Artist art : list) {
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
