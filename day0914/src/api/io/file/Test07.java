package api.io.file;

import java.io.File;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) {
		// 파일 또는 디렉터리의 생성 및 삭제
		// = 파일과 디렉터리는 생성 명령이 다르다
		// = 이름만으로는 파일인지 디렉터리인지 구분할 수 없기 때문에 명령 자체가 다르다

		// 2. 파일 생성
		File target = new File("sample", "hello.kh");
		System.out.println(target.exists());
		System.out.println(target.isFile());
		System.out.println(target.isDirectory());

		try {
			boolean result = target.createNewFile();
			System.out.println("result = " + result);
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("파일 생성 오류 발생");
		}

//		target.delete();//파일 삭제는 폴더 삭제와 동일하다.

	}
}
