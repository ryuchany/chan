package api.lang.string;

public class Test03 {
	public static void main(String[] args) {

		// 문자열의 부분 비교
		// = 문자열이 특정값으로 시작합니까? startsWith()
		// = 문자열이 특정 값으로 끝납니까? endsWith()
		// = 문자열에 특정 값이 포함되어 있습니까? contains()
		// = 문자열에 특정 값이 어디에 있습니까? indexOf() - 왼쪽부터, lastIndexOf() - 오른쪽부터

		String homePage = "http://www.naver.com";

		System.out.println(homePage.startsWith("http"));// http로 시작하나요?
		System.out.println(homePage.endsWith(".com"));// .com으로 끝나나요?
		System.out.println(homePage.contains("naver"));// naver라는 글자가 포함되어 있나요?
		System.out.println(homePage.indexOf("naver"));// naver라는 글자가 어디에 있나요?(좌측부터)
		System.out.println(homePage.lastIndexOf("naver"));// naver라는 글자가 어디에 있나요?(우측부터)
	}
}
