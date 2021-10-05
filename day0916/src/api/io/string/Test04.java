package api.io.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
		// FileWriter를 사용한 문자열 출력
		// 1. 버퍼의 크기를 변경할 수 있는가?
		// --> BufferedWriter 사용
		// 2. 한줄단위 출력 또는 다른 유형의 데이터도 문자열로 출력?
		// --> PrintWriter 사용

		File target = new File("sample", "string.txt");
		FileWriter out = new FileWriter(target);

		out.write("안녕 Java!");
		out.write("\n");
		out.write("안녕 Java!");
		out.write("\n");
		out.write("안녕 Java!");
		out.write("\n");

		int a = 100;
//		out.write(a);
//		out.write("100");
		out.write(String.valueOf(a));

//		out.flush();
		out.close();
	}
}
