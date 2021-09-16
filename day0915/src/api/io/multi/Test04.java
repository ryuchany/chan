package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {

		File target = new File("sample", "lotto.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);

		for (int i = 0; i < 6; i++) {
			int number = data.readInt();
			System.out.println(number);
		}

		data.close();
	}
}
