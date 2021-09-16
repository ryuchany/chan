package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Test04_3 {
	public static void main(String[] args) throws IOException {
		//sample/lotto.txt 에 저장된 로또번호를 불러와서 화면에 출력

		Set<Integer> set = new TreeSet<>();

		//도구 생성
		File target = new File("sample", "lotto.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);

		for(int i=0; i < 6; i++) {
			set.add(data.readInt());
		}
		data.close();

		System.out.println(set);
	}
}
