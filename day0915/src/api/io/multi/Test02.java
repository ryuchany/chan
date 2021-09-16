package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		//Multi-Byte 입력

		//준비물 : 
		//- 조립 도구(DataInputStream)
		//- 버퍼(BufferedInputStream)
		//- 입력스트림(FileInputStream)
		//- 입력 파일 객체(File)

		//도구 생성
		File target = new File("sample", "multi.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);

		//[프로그램] ← data ← buffer ← in ← target ← [multi.txt]

		int a = data.readInt();					//파일에서 4byte를 읽어 int 형태로 조립한 뒤 반환
		double b = data.readDouble();		//파일에서 8byte를 읽어 double 형태로 조립한 뒤 반환
		float c = data.readFloat();			//파일에서 4byte를 읽어 float 형태로 조립한 뒤 반환
		char d = data.readChar();				//파일에서 2byte를 읽어 char 형태로 조립한 뒤 반환
		byte e = data.readByte();				//파일에서 1byte를 읽어 byte 형태로 조립한 뒤 반환
		short f = data.readShort();			//파일에서 2byte를 읽어 short 형태로 조립한 뒤 반환
		long g = data.readLong();			//파일에서 8byte를 읽어 long 형태로 조립한 뒤 반환
		boolean h = data.readBoolean();	//파일에서 1byte를 읽어 boolean 형태로 조립한 뒤 반환

		//통로 정리
		data.close();//--> buffer.close() --> in.close()

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		System.out.println("g = " + g);
		System.out.println("h = " + h);
	}
}
