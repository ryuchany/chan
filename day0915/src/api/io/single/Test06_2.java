package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.Format;

public class Test06_2 {
	public static void main(String[] args) throws IOException {
		//복사 프로그램을 byte[] 입출력으로 변경

		String originFileName = "sample/origin.txt";
		String copyFileName = "sample/copy.txt";

		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);

		InputStream originFileStream = new FileInputStream(originFile);
		OutputStream copyFileStream = new FileOutputStream(copyFile);

		//구조 : [origin.txt] → originFile → originFileStream 
		//					→ [프로그램] → copyFileStream → copyFile → [copy.txt]
		byte[] buffer = new byte[5];

		//진행상황 확인 코드 추가
		Format f = new DecimalFormat("#,##0.00");
		long total = originFile.length();
		long count = 0L;

		while(true) {
			int size = originFileStream.read(buffer);
			if(size == -1) break;
			copyFileStream.write(buffer, 0, size);//+0부터 size개만큼 출력

			count += size;
			float percent = count * 100f / total;
			System.out.println("총 "+total+"바이트 중 "+count+"바이트 복사 완료 ("+f.format(percent)+" % )");
		}

		//통로 종료
		originFileStream.close();
		copyFileStream.close();

	}
}
