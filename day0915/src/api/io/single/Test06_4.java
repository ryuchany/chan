package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.Format;

public class Test06_4 {
	public static void main(String[] args) throws IOException {
		// 복사 프로그램을 byte[] 입출력으로 변경

		String originFileName = "D:/jdk-8u301-windows-x64.exe";// 약 200MB
		String copyFileName = "D:/copy.exe";

		File originFile = new File(originFileName);
		File copyFile = new File(copyFileName);

		FileManager.copyFile(originFile, copyFile, true);

	}
}
