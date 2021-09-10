package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05 {
	public static void main(String[] args) {
		// Collections 클래스를 이용한 List 보조 처리

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}

		System.out.println(list);

		//순서 반대로 바꾸기(reverse)
		Collections.reverse(list);
		System.out.println(list);

		//순서 랜덤으로 섞기(shffle)
		Collections.shuffle(list);
		System.out.println(list);

		//순서대로 정렬(sort)
		Collections.sort(list);
		System.out.println(list);
	}
}
