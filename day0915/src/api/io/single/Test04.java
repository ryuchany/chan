package api.io.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test04 {
	public static void main(String[] args) throws IOException {
		// Q : Single-Byte 입출력에서 성능 저하가 발생하는 원인
		// A : 자바의 특징
		// = 운영체제에 독립적이고 이식성이 뛰어나다
		// = 운영체제와 별로 안친하다
		// = 운영체제의 허락(System call)이 필요한 작업이 오래 걸린다
		// 해결책 :
		// = 운영체제와 친해진다(Java의 장점이 다 사라짐)
		// = 운영체제의 허락을 최대한 적게 받는다(ex : 1개씩 옮기는게 아니라 100개씩 옮긴다면?)
		// = 1개씩 옮기면 100개를 옮기는데 100번의 허락이 필요
		// = 100개씩 옮기면 100개를 옮기는데 1번의 허락이 필요
		// = 묶음으로 옮기기 위해 생성하는 임시 저장소를 버퍼(Buffer)라고 부른다

		File target = new File("sample", "single.txt");
		OutputStream out = new FileOutputStream(target);

//		out.write(104);
//		out.write(101);
//		out.write(108);
//		out.write(108);
//		out.write(111);

		byte[] buffer = new byte[] { 104, 101, 108, 108, 111 };

		out.write(buffer);// buffer에 들어있는 값을 전부 출력하세요

		out.write('\n');

		out.write(buffer, 0, 4);// buffer에 들어있는 값을 0번위치부터 4개 출력

		out.write('\n');

		out.write(buffer, 1, 3);// buffer에 들어있는 값을 1번위치부터 3개 출력

		out.close();
	}
}
