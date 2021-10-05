package api.regex;

import java.util.regex.Pattern;

public class Test04 {
	public static void main(String[] args) {
		String id = "asdasd@asdasddd.co.kr";
		String regex = "^[a-z][a-z\\d-9-_]{4,19}@[a-z]{8,10}(\\.com|\\.net|\\.co\\.kr)$";// 첫 글자는 반드시 영문 소문자
		boolean result = Pattern.matches(regex, id);
		if (result) {
			System.out.println("멋진 아이디네요!");
		} else {
			System.out.println("앞 5~20자, 뒤 8~10자리 이내에 이름만 사용 가능합니다");
		}

	}
}
