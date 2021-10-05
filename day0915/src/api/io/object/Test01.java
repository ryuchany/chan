package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//객체 입출력(Object I/O)
		//= 객체는 만들어봐야 크기를 알 수 있다(new)
		//= 여러 개의 데이터가 섞여있으므로 얇게 펼쳐서 분해를 해야 한다
		//= 얇게 펼치는 작업을 직렬화(Serialize)라고 부른다
		//= 객체를 분해하면 다수의 byte 조각이 나오게 되므로 버퍼(Buffer)가 필요하다.

		////////////////////////////////////////////////////////////////////////////
		// 주의 ! 자격이 없는 클래스는 객체 입출력이 불가능하다(java.io.Serializable 인터페이스 상속여부)
		////////////////////////////////////////////////////////////////////////////

		//필요 도구
		//= 직렬화 및 분해 도구(ObjectOutputStream)
		//= 버퍼(BufferedOutputStream)
		//= 출력스트림(FileOutputStream)
		//= 출력 대상 파일 객체(File)

		File target = new File("sample", "time.h");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream oData = new ObjectOutputStream(buffer);

		//[프로그램] → oData → buffer → out → target → [time.kh]

		Date d = new Date();
		oData.writeObject(d);//d라는 객체를 펼쳐서 뿌셔서 출력해라(--> 버퍼로 이동)

		//oData.flush();//buffer가 꽉 찬 상태가 아닐 때 강제로 비우는 명령
		oData.close();
	}
}
