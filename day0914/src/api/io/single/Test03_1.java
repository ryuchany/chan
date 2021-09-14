package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Test03_1 {
	public static void main(String[] args) throws IOException {

		File origin = new File("sample", "origin.txt");
		FileInputStream in = new FileInputStream(origin);

		while (true) {
			int data = in.read();
			if (data == -1)
				break;
			System.out.println("data = " + data);
		}

		in.close();

	}
}
