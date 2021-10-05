package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test04_2 {
	public static void main(String[] args) {
		//Generic type 에는 클래스만 작성할 수 있다(only 참조형)
		List<Integer> list = new ArrayList<>();

		list.add(12);
		list.add(21);
		list.add(22);
		list.add(30);
		list.add(35);
		list.add(36);

		//확장 반복(foreach)문
		//= 전체를 편하게 꺼낼 수 있는 반복문
		//= 일부분은 꺼낼 수 없음
		//= index가 필요하지 않음(알 수 없음)
		//= Iterable을 상속받은 클래스는 모두 foreach 구문을 사용할 수 있다.
		for(int n : list) {
			System.out.println(n);
		}
	}
}
