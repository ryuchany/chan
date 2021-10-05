package api.lang.etc;

public class Test02 {
	public static void main(String[] args) {
		// System 클래스
		// = 생성자가 없는 클래스이며 편리하게 이용하도록 전 구성요소가 static 처리되어 있다
		// = 운영체제(OS)의 정보를 이용할 수 있도록 구성된 클래스

		// 통로
		// = System.out 은 표준 출력 통로 객체
		// = System.in 은 표준 입력 통로 객체
		// = System.err 는 표준 오류 통로 객체
		System.out.println("테스트");
		System.err.println("테스트");

		// 현재시각 구하기(ms)
		// = 기준시(1970년 1월 1일 0시 0분 0초)로부터 지금까지 흘러온 밀리초를 반환
		// = 시간차를 구할 때 사용(소요시간)
		long time = System.currentTimeMillis();
		System.out.println("time = " + time);

		// 운영체제의 정보를 읽어올 수 있다(ex : 환경변수)
		// = System.getProperties()는 등록된 모든 정보를 반환
		// = System.getProperty("이름")은 해당 이름에 저장된 정보를 반환

		System.out.println(System.getProperties());

		System.out.println(System.getProperty("user.country"));
		String country = System.getProperty("user.country");
		switch (country) {
		case "KR":
			System.out.println("만나서 반가워요~");
			break;
		case "US":
			System.out.println("Good to see you~");
			break;
		}

		System.out.println(System.getProperty("os.name"));
		String os = System.getProperty("os.name");
		if (os.startsWith("Windows")) {
			System.out.println("윈도우에서 실행하셨네요?");
		} else {
			System.out.println("윈도우가 아니네요?");
		}

		System.out.println(System.getProperty("java.specification.version"));
		double javaVersion = Double.parseDouble(System.getProperty("java.specification.version"));
		if (javaVersion < 9) {
			System.out.println("자바 9 이상으로 업그레이드 하세요!");
		}

		// 프로그램 종료
		// 운영체제는 0이 반환되면 정상 종료되었다고 판단. 0이 아닌 숫자가 반환되면 뭔가 이상하게 끝났다고 판단
		System.exit(0);// 프로그램을 종료하면서 시스템에 0을 반환하라~
		System.out.println("메세지!");

	}
}