package api.io.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test07 {
	public static void main(String[] args) throws IOException {
		//문자열 입력
		//= 글자 수를 정해서 입력을 받는 방법 또는 줄 단위로 입력받는 것이 원칙

		//도구 : 파일 객체, FileReader
		char[] buffer = new char[10];

		File target = new File("sample", "string.txt");
		FileReader in = new FileReader(target);

		StringBuilder builder = new StringBuilder();

		while(true) {
			int size = in.read(buffer);
			if(size == -1) break;
//			System.out.println("size = " + size);
//			System.out.println("buffer = " + Arrays.toString(buffer));
			builder.append(buffer, 0, size);
		}

		in.close();

		System.out.println(builder.toString());
	}
}

