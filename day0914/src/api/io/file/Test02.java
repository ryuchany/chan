package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		File f = new File("sample", "test.txt");
		System.out.println(f.exists());

		// 파일 정보 분석
		// 1. 파일명
		System.out.println(f.getName());
		// 2. 파일 위치(경로)
		// = 상대 경로란 특정 지점을 기준으로 계산한 경로를 의미한다(우리 옆집)
		// = 절대 경로란 어떠한 경우에도 변하지 않는 경로를 의미한다(서울시 영등포구 선유로길 59 이레빌딩)
		System.out.println(f.getPath());// 상대경로(relative path)
		System.out.println(f.getAbsolutePath());// 절대경로(absolute path)
		// 3. 파일 크기 : 반환형이 long임을 주의해야 한다
		System.out.println(f.length());
		// 4. 최종 수정 시각 : 최신 파일 여부를 판단할 때 사용
		System.out.println(f.lastModified());

		Date d = new Date(f.lastModified());
		Format form = new SimpleDateFormat("yyyy-MM-dd E a h:mm:ss");
		System.out.println(form.format(d));

		// 5. 숨김 파일인지 확인
		System.out.println(f.isHidden());

		// 6. 읽기 전용인지 확인
		System.out.println(f.canRead());
		System.out.println(f.canWrite());
	}
}
