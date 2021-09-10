package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		// Generic type 에는 클래스만 작성할 수 있다(only 참조형)
		List<Integer> list = new ArrayList<>();

		list.add(12);
		list.add(21);
		list.add(22);
		list.add(30);
		list.add(35);
		list.add(36);

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
	}
}
