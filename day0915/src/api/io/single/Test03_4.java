package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.Format;

public class Test03_4 {
	public static void main(String[] args) throws Exception{

		//입력
		String originFileName = "sample/origin.txt";
		String copyFileName = "sample/copy.txt";

		//복사
		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);
		//copyFile.createNewFile();//출력 시 자동 생성되므로 생략 가능

		FileInputStream originFileStream = new FileInputStream(originFile);	
		FileOutputStream copyFileStream = new FileOutputStream(copyFile);

		//진행상황 표시
		//= 원본 파일의 byte 크기
		//= 복사 완료한 byte 크기
		Format f = new DecimalFormat("#,##0.00");
		long total = originFile.length();
		long count = 0L;
		while(true) {
			int data = originFileStream.read();
			if(data == -1) break;

			copyFileStream.write(data);
			count++;

			float percent = count * 100f / total;
			System.out.println("총 "+total+"byte 중 "+count+"byte 복사 완료("+f.format(percent)+" %)");
		}

		//stream 종료
		originFileStream.close();
		copyFileStream.close();

	}
}
