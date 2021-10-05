package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test06 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File target = new File("sample", "student.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream oData = new ObjectInputStream(buffer);

		Student stu = (Student) oData.readObject();

		oData.close();

		System.out.println(stu);
	}
}
