package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test04 {
	public static void main(String[] args) {

		// 로또 문제를 List처럼 풀이
		Set<Integer> lotto = new TreeSet<>();

		Random r = new Random();
		for (int i = 0; i < 6; i++) {
			int number = r.nextInt(45) + 1;
			if (!lotto.contains(number)) {
				lotto.add(number);
			} else {
				i--;
			}
		}

		System.out.println(lotto);

	}
}
