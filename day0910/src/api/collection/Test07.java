package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
//		비복원추출 예시코드

		List<Integer> bowl = new ArrayList<>();
//		List<Integer> bowl = new LinkedList<>();
		for(int i=1; i <=45; i++) {
			bowl.add(i);//auto-boxing 코드(int ---> Integer)
		}

		Collections.shuffle(bowl);
		System.out.println(bowl);

		//앞에서 6개를 잘라내서 새롭게 보관
		List<Integer> lotto = bowl.subList(0, 6);
		System.out.println(lotto.getClass());

		Collections.sort(lotto);
		System.out.println(lotto);

	}
}
