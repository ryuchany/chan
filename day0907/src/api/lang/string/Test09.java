package api.lang.string;

public class Test09 {
	public static void main(String[] args) {
		// 문자열 기타 명령들

		// 1. 문자열 분해 - split()
		String colors = "빨강/주황/노랑/초록/파랑/남색/보라";

		String[] colorList = colors.split("/");// 슬래시(/)를 구분자(delimiter)로 하여 문자열 분해

		System.out.println("색상은 총 " + colorList.length + "개 있습니다");
		for (int i = 0; i < colorList.length; i++) {
			System.out.println(colorList[i]);
		}

		// 2. 원시형 자료형과의 변환(ex : int <----> String)
		int a = 10;
		// String b = a;//에러
		// String b = (String)a;//에러
		// String b = "" + a;//편법 : 문자열 덧셈은 결과가 문자열
		String b = String.valueOf(a);
		System.out.println("b = " + b);

		String c = "12345";
		// int d = c;
		// int d = (int)c;
		int d = Integer.parseInt(c);// 변환 명령(String ---> int)
		System.out.println("d = " + d);

	}
}
