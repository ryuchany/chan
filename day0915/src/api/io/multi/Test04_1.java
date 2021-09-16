package api.io.multi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Test04_1 {
	public static void main(String[] args) throws IOException {
		// sample/lotto.txt 에 저장된 로또번호를 불러와서 화면에 출력

		int[] lotto = new int[6];

		// 도구 생성
		File target = new File("sample", "lotto.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream data = new ObjectInputStream(buffer);
	

		for (int i = 0; i < 6; i++) {
			lotto[i] = data.readInt();
		}
		data.close();

		System.out.println(Arrays.toString(lotto));
	}
}
