package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//객체 입력

		//필요 도구
		//= 역직렬화 및 조립 도구(ObjectInputStream)
		//= 버퍼(BufferedInputStream)
		//= 입력스트림(FileInputStream)
		//= 입력 파일 객체(File)

		File target = new File("sample", "time.h");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream oData = new ObjectInputStream(buffer);
//		ObjectInputStream oData = new ObjectInputStream(
//															new BufferedInputStream(
//																	new FileInputStream(target)));

//		주의 : 보관형태가 Object이기 때문에, 반드시 원래 형태로 다운캐스팅을 해야 사용 가능
		Date d = (Date)oData.readObject();

		oData.close();

		System.out.println(d);
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(d));
	}
}
