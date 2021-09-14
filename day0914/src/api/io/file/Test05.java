package api.io.file;

import java.io.File;

public class Test05 {
	public static void main(String[] args) {
		// 경로 이동
		// = 상위 경로로 이동 또는 하위 경로로 이동

		File f = new File("sample", "test.txt");
		f = f.getAbsoluteFile();// 절대 경로를 기준으로 파일 객체를 재생성
		System.out.println(f.getAbsolutePath());

		// 상위 경로로 이동(탐색기의 ↑ 화살표)
		// File dir = f의 상위 파일 객체;
		File dir = f.getParentFile();
		System.out.println(dir.getAbsolutePath());

		dir = dir.getParentFile();
		System.out.println(dir.getAbsolutePath());

		// 하위 경로로 이동(대상 디렉터리의 이름이 필요)
		dir = new File(dir, "sample");
		System.out.println(dir.getAbsolutePath());

	}
}
