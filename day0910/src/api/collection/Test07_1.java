package api.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test07_1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}

		List<Integer> list2 = new LinkedList<>(list);//ArrayList를 LinkedList로 변환할 수 있다.
		System.out.println(list);
		System.out.println(list2);
	}
}
