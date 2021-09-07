package api.lang.wrapper;

public class Test01 {
	public static void main(String[] args) {
		// Wrapper 클래스 : 기본 자료형을 객체화한 클래스(하이브리드 클래스)
		// = int는 원시형이고, Integer는 참조형이며 서로 호환이 가능하다

		// 1. Integer에는 두 가지 생성방법이 있는데, 각각의 방법을 이용하여 `a`, `b`라는 이름으로 100을 설정한 객체를 생성
		Integer a = new Integer(100);
		Integer b = new Integer("100");

		// 2. `a`와 `b`의 해시코드 및 요약정보를 출력
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		System.out.println(a.toString());
		System.out.println(b.toString());

		// 3. int의 최소값, 최대값을 가진 변수를 찾아 화면에 출력
		System.out.println(Integer.BYTES);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		// 4. 100을 16진수, 8진수, 2진수로 각각 변환하여 출력
		System.out.println(Integer.toHexString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toBinaryString(100));
	}
}
