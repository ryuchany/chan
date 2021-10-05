package api.lang.string;

public class Test07_6 {
	public static void main(String[] args) {
//		문자열 덧셈 (원하는 개수만큼 별 문자열 만들기)
//		= 크기가 커질 수록 소요 시간이 기하급수적으로 늘어난다
//		= 문자열 덧셈은 크기가 커질 수록 사용하지 말아야 한다
//		= 자바는 문자열을 처리할 때 새로 복사본을 만들어서 작업을 수행한다.
//		= 문자열은 한 번 정해지면 크기가 불변이기 때문

		int size = 50000;

//		String star = null;//초기값으로 사용할 수 없음
		String star = "";// empty string, 빈 문자열

		long a = System.currentTimeMillis();// 기준시(1970.01.01 자정)부터 지금까지 흘러온 밀리초(ms)

		for (int i = 0; i < size; i++) {
			star += "*";
		}

		long b = System.currentTimeMillis();
		long ms = b - a;

		System.out.println(ms + " ms");

//		System.out.println(star);
	}
}
