package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		// Single Byte 입력
		// 준비물 : FileInputStream, File 객체

		File target = new File("sample", "single.txt");
		FileInputStream in = new FileInputStream(target);

		// 구조 : [프로그램] ← in ← target ← [single.txt]

		int data = in.read();
		System.out.println("data = " + data);

		// 통로 정리
		in.close();
	}
}
