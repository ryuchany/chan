package api.collection2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		// 집합연산?
		// = 서로 다른 두 집합 간의 연산
		// = 합집합, 교집합, 차집합

		// List<Integer> a = new ArrayList<>();
		List<Integer> a = Arrays.asList(10, 20, 30);// 10, 20, 30이 들어있는 크기 고정 List 생성(불변)
		List<Integer> b = Arrays.asList(20, 30, 40, 50);// 20, 30, 40, 50이 들어있는 불변 List

		System.out.println(a);
		System.out.println(b);

		List<Integer> c = new ArrayList<>();
//		c.addAll(a);
//		c.addAll(b);
		for (int n : a) {
			if (!c.contains(n)) {
				c.add(n);
			}
		}
		for (int n : b) {
			if (!c.contains(n)) {
				c.add(n);
			}
		}
		System.out.println(c);
	}
}
