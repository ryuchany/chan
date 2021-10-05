package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test03_3 {
	public static void main(String[] args) throws Exception {

		// 입력
		String originFileName = "sample/origin.txt";
		String copyFileName = "sample/copy.txt";

		// 복사
		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);
		// copyFile.createNewFile();//출력 시 자동 생성되므로 생략 가능

		FileInputStream originFileStream = new FileInputStream(originFile);
		FileOutputStream copyFileStream = new FileOutputStream(copyFile);

		// 파일 크기를 모른다면 EOF 까지 읽도록 구현
		while (true) {
			int data = originFileStream.read();
			if (data == -1)
				break;
			copyFileStream.write(data);
		}

		// stream 종료
		originFileStream.close();
		copyFileStream.close();

	}
}
