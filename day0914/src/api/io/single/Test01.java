package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test01 {
	public static void main(String[] args) throws IOException {
		// Single Byte 출력
		// 준비물 : FileOutputStream, File

		// 파일 생성
		File target = new File("sample", "single.txt");
		target.createNewFile();

		// 파일 출력 스트림 생성
		OutputStream out = new FileOutputStream(target);

		// 구조 : [프로그램] → out → target → [single.txt]

		// 파일 출력 :
		out.write(104);// h
		out.write(101);// e
		out.write(108);// l
		out.write(108);// l
		out.write(111);// o
		out.write(9);// tab(\t)
		out.write('J');
		out.write('a');
		out.write('v');
		out.write('a');
		out.write('\n');// enter(10)

		// byte를 초과한 데이터(50000 ---> 80로 강제변환)
		// =byte를 초과한 데이터 넣어도 의미없다
		// =단순하게 편의성을 위해 데이터 넣어도 의미없다
		// =50000 ---> (byte)50000 --->0
		out.write(50000);

		// 통로는 반드시 마지막에 닫아야한다(cf : Scanner)
		out.close();

	}
}
