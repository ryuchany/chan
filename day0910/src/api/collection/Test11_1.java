package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test11_1 {
	public static void main(String[] args) {
		//5명의 아티스트들을 리스트에 등록한 뒤 출력하는 프로그램
		List<Artist> list = new ArrayList<>();

		//추가
		list.add(new Artist("녹두", "보컬"));
		list.add(new Artist("대니구", "바이올린"));
		list.add(new Artist("제이유나", "보컬"));
		list.add(new Artist("박다울", "거문고"));
		list.add(new Artist("황린", "일렉기타"));

		//출력
		for(int i=0; i < list.size(); i++) {
			Artist art = list.get(i);
			System.out.println(art);
		}

		System.out.println();

		for(Artist art : list) {
			System.out.println(art);
		}
	}
}
