package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.Format;

public class Test06_3 {
	public static void main(String[] args) throws IOException {
		// 복사 프로그램을 byte[] 입출력으로 변경

		String originFileName = "D:/jdk-8u301-windows-x64.exe";// 약 200MB
		String copyFileName = "D:/copy.exe";

		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);

		InputStream originFileStream = new FileInputStream(originFile);
		OutputStream copyFileStream = new FileOutputStream(copyFile);

		// 구조 : [origin.txt] → originFile → originFileStream
		// → [프로그램] → copyFileStream → copyFile → [copy.txt]
		byte[] buffer = new byte[8192];

		// 진행상황 확인 코드 추가
		Format f = new DecimalFormat("#,##0.00");
		long total = originFile.length();
		long count = 0L;

		long start = System.currentTimeMillis();

		while (true) {
			int size = originFileStream.read(buffer);
			if (size == -1)
				break;
			copyFileStream.write(buffer, 0, size);// +0부터 size개만큼 출력

			count += size;
			float percent = count * 100f / total;
			System.out.println("총 " + total + "바이트 중 " + count + "바이트 복사 완료 (" + f.format(percent) + " % )");
		}

		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.println("소요시간 : " + time + "ms");

		// 통로 종료
		originFileStream.close();
		copyFileStream.close();

	}
}
