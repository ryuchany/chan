package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test03_2 {
	public static void main(String[] args) throws IOException {

		
		
		
		
		File copy = new File("sample", "copy.txt");
//		copy.createNewFile();
		FileOutputStream out = new FileOutputStream(copy);

		File origin = new File("sample", "origin.txt");
		FileInputStream in = new FileInputStream(origin);

		while (true) {
			int data = in.read();
			if (data == -1)
				break;
			out.write(data);
		}

		out.close();
		in.close();

	}
}
