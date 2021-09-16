package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) throws IOException {
		// 버퍼(Buffer)를 사용하여 한 번에 여러 개의 바이트 읽기
		// = 파일마다 크기(byte수)가 다르다
		// = buffer를 만들 때 일정 크기를 지정해서 만들어야 한다.
		// = "적당한" 크기가 얼마인지에 대해서 이해할 필요가 있다.

		File target = new File("sample", "single.txt");
		InputStream in = new FileInputStream(target);

		// ex : 버퍼 크기를 5로 설정하여 읽어들이는 예제(현재 파일크기는 14byte)
		// --> 예상 시나리오
		// --> 첫 번째 읽으면 : 5byte
		// --> 두 번째 읽으면 : 5byte
		// --> 세 번째 읽으면 : 4byte
		byte[] buffer = new byte[5];

		int n = in.read(buffer);
		System.out.println("n = " + n);
		System.out.println("buffer = " + Arrays.toString(buffer));

		// 통로 종료
		in.close();
	}
}
