package api.regex;

public class Test01 {
	public static void main(String[] args) {
		// 정규 표현식(REGEX, REGular EXpression)
		// = 문자열을 검사하는 식
		// = ex : 올바른 휴대폰 번호인지 검사(01X-XXXX-XXXX)

		String phoneNumber = "010-1212-3434";

		if (phoneNumber.length() == 13) {
			boolean check1 = phoneNumber.charAt(0) == '0';
			boolean check2 = phoneNumber.charAt(1) == '1';
			boolean check3 = phoneNumber.charAt(2) == '0';
			boolean check4 = phoneNumber.charAt(3) == '-';
			boolean check5 = phoneNumber.charAt(4) >= '0' && phoneNumber.charAt(4) <= '9';
			boolean check6 = phoneNumber.charAt(5) >= '0' && phoneNumber.charAt(5) <= '9';
			boolean check7 = phoneNumber.charAt(6) >= '0' && phoneNumber.charAt(6) <= '9';
			boolean check8 = phoneNumber.charAt(7) >= '0' && phoneNumber.charAt(7) <= '9';
			boolean check9 = phoneNumber.charAt(8) == '-';
			boolean check10 = phoneNumber.charAt(9) >= '0' && phoneNumber.charAt(9) <= '9';
			boolean check11 = phoneNumber.charAt(10) >= '0' && phoneNumber.charAt(10) <= '9';
			boolean check12 = phoneNumber.charAt(11) >= '0' && phoneNumber.charAt(11) <= '9';
			boolean check13 = phoneNumber.charAt(12) >= '0' && phoneNumber.charAt(12) <= '9';

			if (check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8 && check9 && check10
					&& check11 && check12 && check13) {
				System.out.println("올바른 전화번호 형식입니다");
			} else {
				System.out.println("잘못된 전화번호 형식입니다");
			}
		} else {
			System.out.println("잘못된 전화번호 형식입니다");
		}

	}
}
