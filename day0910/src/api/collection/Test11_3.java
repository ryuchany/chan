package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test11_3 {
	public static void main(String[] args) {
		// 저장되어있는 아티스트들을 "이름"으로 찾는 프로그램
		List<Artist> list = new ArrayList<>();

		// 추가
		list.add(new Artist("녹두", "보컬"));
		list.add(new Artist("대니구", "바이올린"));
		list.add(new Artist("제이유나", "보컬"));
		list.add(new Artist("박다울", "거문고"));
		list.add(new Artist("황린", "일렉기타"));

		// 검색
		String name = "대니구";

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

		// 결과
//		System.out.println("find = " + find);
		if (find == null) {
			System.out.println("찾으시는 이름은 존재하지 않습니다");
		} else {
			System.out.println(name + " 에 대한 검색 결과");
			System.out.println(find);
		}

	}
}
