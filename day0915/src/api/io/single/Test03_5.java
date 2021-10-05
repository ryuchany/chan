package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.Format;

public class Test03_5 {
	public static void main(String[] args) throws Exception {
		// 입력
		String originFileName = "sample/origin.txt";
		String copyFileName = "sample/copy.txt";

		// 복사
		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);
		// copyFile.createNewFile();//출력 시 자동 생성되므로 생략 가능

		FileManager.copyFile(originFile, copyFile);// debug off
		// FileManager.copyFile(originFile, copyFile, false);//debug off
		// FileManager.copyFile(originFile, copyFile, true);//debug on(진행상황 표시)
	}
}
