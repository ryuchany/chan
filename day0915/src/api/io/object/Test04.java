package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// 도구 준비
		File target = new File("sample", "lotto2.txt");
		if (!target.exists()) {
			System.err.println("파일이 존재하지 않습니다");
			System.exit(-1);
		}

		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream oData = new ObjectInputStream(buffer);

		// 경고는 Set의 내용물까지는 확신할 수 없기 때문에 발생한다.
		Set<Integer> lotto = (Set<Integer>) oData.readObject();

		oData.close();

		for (int number : lotto) {
			System.out.println(number);
		}
	}
}
