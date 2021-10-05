package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		//리스트(List)
		//= 저장 순서를 유지(기억)하는 저장소
		//= 위치에 기반한 데이터 관리를 수행

		List<String> list = new ArrayList<String>();

		//추가 - add()
		list.add("아이유");//마지막 추가(index = 0)
		list.add("김을동");//마지막 추가(index = 1 → 2)
		list.add("박보영");//마지막 추가(index = 2 → 3)
		list.add("차은우");//마지막 추가(index = 3 → 4)
		list.add("태연");//마지막 추가(index = 4 → 5)
		list.add(1, "한지민");//중간삽입(index = 1)

		//출력
		System.out.println(list);

		//개수 확인 - size() . 배열처럼 공간 개수가 아니라 "실제 데이터" 개수
		System.out.println(list.size());

		//검색 - contains()
		System.out.println(list.contains("태연"));//태연이 저장소에 있는가?
		System.out.println(list.contains("유재석"));//유재석이 저장소에 있는가?

		//확인 - get(index)
		System.out.println(list.get(3));//3번 위치에 있는 이름은 무엇입니까?

		//전체 출력
		System.out.println("----------");
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		//삭제 - remove()
		list.remove("한지민");
		list.remove(0);

		System.out.println(list);
		System.out.println(list.size());
	}
}
