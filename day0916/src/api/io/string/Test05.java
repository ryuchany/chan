package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test05 {
	public static void main(String[] args) throws IOException {
		// 필요한 Writer들을 조합하여 사용
		// = System.out 도 PrintWriter 형태의 객체이다.

		File target = new File("Sample", "string.txt");
		FileWriter out = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(out, 8192);// 외장버퍼
		PrintWriter printer = new PrintWriter(buffer);// 출력도우미

		// [프로그램] → printer → buffer → out → target → [string.txt]

		// write가 아니라 print 계열의 명령으로 출력을 할 수 있도록 지원
		printer.println("안녕 Java!");
		printer.println("안녕 Java!");
		printer.println("안녕 Java!");

		int a = 100;
		printer.println(a);

//		printer.flush();
		printer.close();

	}
}
