package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) {

//		경로 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("경로 입력 : ");
		String path = sc.nextLine();
		sc.close();

//		파일 객체 생성
		File file = new File(path);

		if (file.exists()) {// 존재하는 경우(파일 또는 디렉터리)
			if (file.isFile()) {
				System.out.println("[파일 정보]");
				System.out.println("이름 : " + file.getName());
				System.out.println("절대경로 : " + file.getAbsolutePath());
				System.out.println("크기 : " + file.length() + " byte");
				Format f = new SimpleDateFormat("y년 M월 d일 E h시 m분 s초");
				Date d = new Date(file.lastModified());
				System.out.println("최종 수정 시각 : " + f.format(d));
			}
//			else if(file.isDirectory()) {
			else {
				System.out.println("[디렉터리 정보]");
				System.out.println("이름 : " + file.getName());

				File[] files = file.listFiles();
				for (File f : files) {
					if (f.isFile()) {
						System.out.println("--> [파일] " + f.getName() + " (" + f.length() + " bytes)");
					} else if (f.isDirectory()) {
						System.out.println("--> [폴더] " + f.getName());
					}
				}
			}
		} else {// 존재하지 않는 경우
			System.out.println("해당 경로는 존재하지 않습니다.");
		}
	}
}
