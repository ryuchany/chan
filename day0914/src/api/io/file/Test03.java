package api.io.file;

import java.io.File;

public class Test03 {
	public static void main(String[] args) {
		// 자바에서는 파일 뿐만 아니라 폴더(디렉터리, Directroy)도 File 클래스로 제어가능
		// = 디렉터리란? 파일을 보관하기 위한 틀(껍데기, 통)
		// = 디렉터리는 크기가 없다

		File dir = new File("sample");
		System.out.println(dir.exists());

		// 정보 분석
		// 1. 디렉터리는 크기가 없다.
		System.out.println(dir.length());

		// 2. 이름
		System.out.println(dir.getName());

		// 3. 경로
		System.out.println(dir.getPath());
		System.out.println(dir.getAbsolutePath());

		// 4. 내부의 파일 목록
		// = list() : 이름만 반환
		// = listFiles() : 파일 객체를 반환
		String[] names = dir.list();
		for (String name : names) {
			System.out.println(name);
		}

		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f);
			System.out.println("file? " + f.isFile());
			System.out.println("directory? " + f.isDirectory());
		}

	}
}
