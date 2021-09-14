package api.collection2;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test05 {
	public static void main(String[] args) {
		// Set의 전체 추출 및 출력?
		// = List에서는 index를 이용한 반복이 가능했었으나 Set은 index가 없다.
		// 1. Iterator 이용
		// 2. Foreach 이용
		Set<String> languages = new TreeSet<>();

		languages.add("Java");
		languages.add("Python");
		languages.add("Javascript");
		languages.add("C++");
		languages.add("Go");

		System.out.println(languages);

//		System.out.println(languages.get(0));
//		System.out.println(languages.get(1));
//		System.out.println(languages.get(2));
//		System.out.println(languages.get(3));
//		System.out.println(languages.get(4));

//		1. 이터레이터(Iterator)를 사용하여 추출하는 방법
		Iterator<String> iter = languages.iterator();// Set<String> ----> Iterator<String> 이동

		while (iter.hasNext()) {
			String name = iter.next();
			System.out.println("name = " + name);
		}

//		2. 확장 for문(foreach)를 이용하여 추출하는 방법
		for (String name : languages) {
			System.out.println("name = " + name);
		}
	}
}
