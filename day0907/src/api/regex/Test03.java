package api.regex;

import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) {
		String name = "홍길동";
		String regex = "^[가-힣]{2,7}$";
		boolean result = Pattern.matches(regex, name);
		if (result) {
			System.out.println("올바른 형식의 이름입니다");
		} else {
			System.out.println("이름은 한글 2~7자 이내로 작성하세요");
		}

	}
}