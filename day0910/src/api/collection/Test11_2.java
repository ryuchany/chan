package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test11_2 {
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
		String name = "황린";

		// 1. 비어있는 리모컨을 준비
		Artist find = null;

//		if(0번 위치에 있는 Artist 의 이름이 name과 같다면) {
//			find = 0번 위치의 객체 정보;
//		}
//		if(1번 위치에 있는 Artist 의 이름이 name과 같다면) {
//			find = 1번 위치의 객체 정보;
//		}
//		if(2번 위치에 있는 Artist 의 이름이 name과 같다면) {
//			find = 2번 위치의 객체 정보;
//		}
//		if(3번 위치에 있는 Artist 의 이름이 name과 같다면) {
//			find = 3번 위치의 객체 정보;
//		}
//		if(4번 위치에 있는 Artist 의 이름이 name과 같다면) {
//			find = 4번 위치의 객체 정보;
//		}

		// 결과
		System.out.println("존재하지 않는 이름입니다");

		System.out.println("해당 대상의 정보 출력");

	}
}
