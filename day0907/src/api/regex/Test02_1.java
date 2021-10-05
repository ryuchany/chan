package api.regex;

import java.util.regex.Pattern;

public class Test02_1 {
	public static void main(String[] args) {
		String id = "a_-_-_-_-_-_-_-_-_";
//		String regex = "^[a-z0-9-_]{5,20}$";
		String regex = "^[a-z][a-z0-9-_]{4,19}$";//첫 글자는 반드시 영문 소문자

		boolean result = Pattern.matches(regex, id);
		System.out.println("result = " + result);
		if(result) {
			System.out.println("멋진 아이디네요!");
		}
		else {
			System.out.println("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		}
	}
}
