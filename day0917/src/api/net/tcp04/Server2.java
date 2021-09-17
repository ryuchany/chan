package api.net.tcp04;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Server2 {
	public static void main(String[] args) throws IOException {
		//로또 번호 6개 추첨
		Random r = new Random();
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6) {
			lotto.add(r.nextInt(45) + 1);
		}

		System.out.println(lotto);
	}
}
