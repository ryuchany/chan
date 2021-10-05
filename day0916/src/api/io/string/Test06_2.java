package api.io.string;

import java.io.File;
import java.io.IOException;

public class Test06_2 {
	public static void main(String[] args) throws IOException {

		// 임시파일 생성
		File dir = new File("sample");
		File tempFile = File.createTempFile("temp-", ".txt", dir);

		// 임시 파일은 예약 삭제를 설정
		tempFile.deleteOnExit();

	}
}
