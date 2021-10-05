package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02 {
	public static void main(String[] args) throws IOException {

		// 로또번호 추첨
		Random r = new Random();
		Set<Integer> lotto = new TreeSet<>();

		while (lotto.size() < 6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}

		System.out.println(lotto);

//		객체 출력
		File target = new File("sample", "lotto2.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream oData = new ObjectOutputStream(buffer);
//		ObjectOutputStream oData = new ObjectOutputStream(
//															new BufferedOutputStream(
//																	new FileOutputStream(target)));

		oData.writeObject(lotto);

		oData.close();// flush+close
		System.out.println("로또번호 생성이 완료되었습니다");

	}
}
