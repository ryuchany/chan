package api.io.string;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		// 문자열은 객체 출력, 멀티바이트 출력, 싱글바이트 출력 모두 가능하다.

		// ex : 멀티바이트 출력으로 진행(char 출력)

		String str = "안녕 Java!";

		File target = new File("sample", "string.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);

		for (int i = 0; i < str.length(); i++) {
			data.writeChar(str.charAt(i));
		}

		data.close();// flush + close
	}
}
