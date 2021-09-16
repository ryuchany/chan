package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05 {
	public static void main(String[] args) throws IOException {
		//내가 만든 클래스의 객체 출력
		//= java.io.Serializable을 상속받으면 가능

		File target = new File("sample", "student.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream oData = new ObjectOutputStream(buffer);

		Student stu = new Student("피카츄", 80, "게임");

		oData.writeObject(stu);

		oData.close();
	}
}
