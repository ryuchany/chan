package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02_2 {
	public static void main(String[] args) throws IOException {
		// Single Byte 입력
		// 준비물 : FileInputStream, File 객체

		File target = new File("sample", "single.txt");
		FileInputStream in = new FileInputStream(target);

		// 구조 : [프로그램] ← in ← target ← [single.txt]

		// [2] EOF(-1) 지점까지 읽도록 구현
		while (true) {
			int data = in.read();
			if (data == -1)
				break;
			System.out.println("data = " + data);
		}

		// 통로 정리
		in.close();
	}
}
