package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		// multi-Byte 출력
		// =원시형 데이터 및 UTF-8 문자열에 대한출력
		// =자료형마다 분해 및 조립방법이 다르므로 명령 종류가 다르다
		// =기본적으로 여러 조각의 바이트를 출력 또는 입력해야하므로 버퍼를 무조건 사용해야 한다
		// =Single-Byte 보다 필요한 도구가 많아진다.

		// 준비물 :
		// -분해도구(DataOutputStream)
		// -버퍼(BufferedOutputStream)
		// -출력스트림(FileoutputStream)
		// -출력대상 파일(File)

		File target = new File("sample", "multi.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);// 8192 byte
//		BufferedOutputStream buffer = new BufferedOutputStream(out,4096);//크기 지정
		DataOutputStream data = new DataOutputStream(buffer);

//		구조 : [프로그램] → data → buffer → out → target → [multi.txt]

//		data를 이용하여 출력 명령을 수행
//		=.write() 대신 자료형별로 준비된 명령을 사용
		data.writeInt(100); // 100을 int에 맞게 분해하세요(--> 버퍼로 가세요. 4/8192)
		data.writeDouble(100); // 100을 double에 맞게 분해하세요(--> 버퍼로 가세요. 12/8192)
		data.writeFloat(100); // 100을 float에 맞게 분해하세요(--> 버퍼로 가세요. 16/8192)
		data.writeChar(100); // 100을 char에 맞게 분해하세요(--> 버퍼로 가세요. 18/8192)
		data.writeByte(100); // 100을 byte에 맞게 분해하세요(--> 버퍼로 가세요. 19/8192)
		data.writeShort(100); // 100을 short에 맞게 분해하세요(--> 버퍼로 가세요. 21/8192)
		data.writeLong(100); // 100을 long에 맞게 분해하세요(--> 버퍼로 가세요. 29/8192)
		data.writeBoolean(true); // true를 boolean에 맞게 분해하세요(--> 버퍼로 가세요. 30/8192)

//		버퍼는 저장공간이 꽉 찬 경우만 자동 출력을 수행한다.
//		그 외의 상황이라면 수동 출력(flush)을 수행해야 한다.

//		data.flush();
		data.close();// close() 하면 자동으로 flush() 수행된다.
	}
}
