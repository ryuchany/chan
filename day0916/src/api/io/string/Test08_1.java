package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test08_1 {
	public static void main(String[] args) throws IOException {
		// 문자열 입력
		// = 글자 수를 정해서 입력받는것이 아니라 줄 단위로 입력받도록 도구를 조합
		// = 줄 단위라 함은 개행문자(\n)를 발견하기 전까지라고 볼 수 있다.

		File target = new File("sample", "string.txt");
		FileReader in = new FileReader(target);
		BufferedReader buffer = new BufferedReader(in);

		// BufferedReader에는 read() 말고 readLine() 이라는 명령이 있다.
		// (주의) EOF == null 이다
		while (true) {
			String line = buffer.readLine();
			if (line == null)
				break;
			System.out.println("line = " + line);
		}

		buffer.close();
	}
}