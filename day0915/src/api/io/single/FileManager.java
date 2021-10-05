package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

//파일 관련된 처리를 수행하는 클래스
public class FileManager {

	// 원클릭
	public static void copy(File origin, File copy) throws IOException {
		copy(origin, copy, false);
	}

	public static void copy(File origin, File copy, boolean debug) throws IOException {
		if (origin.isFile()) {
			copyFile(origin, copy, debug);
		} else if (origin.isDirectory()) {
			copyDirectory(origin, copy, debug);
		}
	}

	// 디렉터리 복사
	public static void copyDirectory(File originDirectory, File copyDirectory) throws IOException {
		copyDirectory(originDirectory, copyDirectory, false);
	}

	public static void copyDirectory(File originDirectory, File copyDirectory, boolean debug) throws IOException {
		if (debug) {
			System.out.println(
					originDirectory.getAbsolutePath() + " → " + copyDirectory.getAbsolutePath() + " 디렉터리 복사 시작");
		}

		// 목적지 디렉터리 생성
		copyDirectory.mkdirs();

		// 내용물을 복사
		File[] list = originDirectory.listFiles();// 원본디렉터리의 내용물을 꺼내서
		if (list != null) {// 내용물이 존재한다면
			for (File file : list) {// 반복하며 복사를 수행
				if (file.isFile()) {// 파일이면
					// copyDirectory 안에 file이랑 같은 이름으로 객체 생성
					File target = new File(copyDirectory, file.getName());
					copyFile(file, target, debug);
				} else if (file.isDirectory()) {
					// copyDirectory 안에 file이랑 같은 이름으로 객체 생성
					File target = new File(copyDirectory, file.getName());
					copyDirectory(file, target, debug);// 재귀호출(같은 이름의 메소드를 다시 호출)
				}
			}
		}

		if (debug) {
			System.out.println(
					originDirectory.getAbsolutePath() + " → " + copyDirectory.getAbsolutePath() + " 디렉터리 복사 시작");
		}
	}

	// 파일 복사(originFile ----> copyFile) : debug off
	public static void copyFile(File originFile, File copyFile) throws IOException {
		copyFile(originFile, copyFile, false);
	}

	// 파일 복사(originFile ----> copyFile) : debug 선택
	public static void copyFile(File originFile, File copyFile, boolean debug) throws IOException {
		if (debug) {
			System.out.println(originFile.getName() + " → " + copyFile.getName() + " 파일 복사 시작");
		}

		FileInputStream originFileStream = new FileInputStream(originFile);
		FileOutputStream copyFileStream = new FileOutputStream(copyFile);

		// 진행상황 표시
		// = 원본 파일의 byte 크기
		// = 복사 완료한 byte 크기
		Format f = new DecimalFormat("#,##0.00");
		long total = originFile.length();
		long count = 0L;

		byte[] buffer = new byte[8192];

		long start = System.currentTimeMillis();

		while (true) {
			int size = originFileStream.read(buffer);
			if (size == -1)
				break;

			copyFileStream.write(buffer, 0, size);
			if (debug) {// debug 설정이 된 경우에만 진행상황을 체크하도록 계산 코드를 실행
				count += size;

				float percent = count * 100f / total;
				System.out.println("총 " + total + "byte 중 " + count + "byte 복사 완료(" + f.format(percent) + " %)");
			}
		}

		long finish = System.currentTimeMillis();

		// stream 종료
		originFileStream.close();
		copyFileStream.close();

		if (debug) {
			System.out.println(originFile.getName() + " → " + copyFile.getName() + " 파일 복사 완료");
			System.out.println("소요시간 : " + (finish - start) + "ms");
		}

	}
}
