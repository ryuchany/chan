package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		// Set
		// = 중복을 허용하지 않는 저장소
		// = 순서가 정해져 있는 저장소
		// = TreeSet, HashSet
		// = (ex) 전화번호부

		Set<String> set = new TreeSet<>();

		// 추가 : add()
		set.add("차은우");
		set.add("아이유");
		set.add("아이유");
		set.add("김을동");
		set.add("공유");
		set.add("한지민");

		// 출력
		System.out.println(set);

		// 개수확인
		System.out.println(set.size());

		// 검색
		System.out.println(set.contains("아이유"));

		// 삭제
		set.remove("공유");
		System.out.println(set);
	}
}
