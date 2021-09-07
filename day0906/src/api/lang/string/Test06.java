package api.lang.string;

public class Test06 {
	public static void main(String[] args) {
		// 문자열 편집
		// = 문자열을 우리가 원하는대로 바꾸는 작업

		// 대소문자 변경
		String text = "Hello World";
		System.out.println(text);
		System.out.println(text.toUpperCase());
		System.out.println(text.toLowerCase());

		// 불필요한 공백 제거
		// = 공백이 아닌 첫글자, 공백이 아닌 마지막 글자를 찾아 그 외 공백을 모두 삭제
		String url = "                        http://www.naver.com                                ";
		System.out.println(url.length());

		System.out.println(url);
		System.out.println(url.trim());
		System.out.println(url.trim().length());

		// 문자열 잘라내기 - substring()
		String korean = "가나다라마바사아자차카타파하";
		System.out.println(korean);
		System.out.println(korean.substring(4, 9));// 4부터 9지점 사이를 잘라내라
		System.out.println(korean.substring(4));// 4부터 잘라내라(~끝까지)

		// 문자열 치환 - replace()
		String msg = "나는 자바가 싫어요";
		System.out.println(msg);
		System.out.println(msg.replace("싫어", "좋아"));
		System.out.println(msg);
		System.out.println(msg.replace("싫어", "좋아").replace("자바", "피자"));
	}
}