package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test03_1 {
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

		//10byte만 복사
		for(int i=0; i < 10; i++) {
			int data = originFileStream.read();
			copyFileStream.write(data);
		}

		//stream 종료
		originFileStream.close();
		copyFileStream.close();

	}
}
