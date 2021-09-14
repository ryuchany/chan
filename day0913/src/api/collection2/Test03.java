package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test03 {
	public static void main(String[] args) {
		// TreeSet의 저장 구조상 Tree의 형태를 취하기 때문에 작은값이 왼쪽, 큰 값이 오른쪽으로 저장됨
		// = 절대로 index를 가질 수 없으므로 index관련 명령이 없다.
		// = indexOf(), get() 과 같은 명령이 없다

		Set<Integer> set = new HashSet<>();

		// 5 → 7 → 13 → 21 → 45 → 93 → 65
		set.add(5);
		set.add(7);
		set.add(13);
		set.add(21);
		set.add(45);
		set.add(93);
		set.add(65);

		System.out.println(set);
		System.out.println(set.size());

//		System.out.println(set.get(0));//될 수가 없다
	}
}
