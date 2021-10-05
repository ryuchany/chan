package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test03 {
	public static void main(String[] args) throws Exception {

		// 1. origin.txt 생성
		File origin = new File("sample", "origin.txt");
//		origin.createNewFile();

		FileOutputStream originOut = new FileOutputStream(origin);

		for (int i = 0; i < 5; i++) {
			originOut.write('h');
			originOut.write('e');
			originOut.write('l');
			originOut.write('l');
			originOut.write('o');
			originOut.write('\t');
			originOut.write('J');
			originOut.write('a');
			originOut.write('v');
			originOut.write('a');
			originOut.write('!');
			originOut.write('\n');
		}

		originOut.close();

		// 2. copy.txt 생성
		File copy = new File("sample", "copy.txt");
//		copy.createNewFile();

		// 3. origin.txt → copy.txt 복사
		FileOutputStream copyOut = new FileOutputStream(copy);
		FileInputStream originIn = new FileInputStream(origin);

		while (true) {
			int data = originIn.read();
			if (data == -1)
				break;
			copyOut.write(data);
		}

		copyOut.close();
		originIn.close();

		// copy.delete();
	}
}
