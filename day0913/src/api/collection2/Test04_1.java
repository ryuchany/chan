package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test04_1 {
	public static void main(String[] args) {

		//Set은 어짜피 중복이 안되므로 size()를 기준으로 반복을 수행
		Set<Integer> lotto = new TreeSet<>();

		Random r = new Random();
//		for(;lotto.size() < 6;) {
		while(lotto.size() < 6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}

		System.out.println(lotto);

	}
}
