package api.lang.string;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("사용할 이메일 입력");
		String email = sc.next();
		sc.close();

//		one	 	이메일은 최소 5글자 이상 최대 50글자 이하로 설정해야 합니다.
//		two	 	이메일에는 반드시 @가 포함되어야 하며 처음과 마지막에 포함될 수 없습니다
//		three	마지막은 반드시 `.com`으로 끝나야 합니다.
//		four		이메일에 `admin`이라는 글자는 사용할 수 없습니다.

		boolean one = email.length() >= 5 && email.length() <= 50;
//		boolean two = email.contains("@") && !email.startsWith("@") && !email.endsWith("@");
//		boolean two = email.contains("@") && email.charAt(0) != '@' && email.charAt(email.length() - 1) != '@';
		boolean two = email.indexOf("@") > 0 && email.indexOf("@") < email.length() - 1;
		boolean three = email.endsWith(".com");
		boolean four = !email.contains("admin");

		boolean isPass = one && two && three && four;

//		System.out.println("one = " + one);
//		System.out.println("two = " + two);
//		System.out.println("three = " + three);
//		System.out.println("four = " + four);
//		System.out.println("isPass = " + isPass);

		if (isPass) {
			System.out.println("이메일 설정이 완료되었습니다");
		} else {
			System.out.println("잘못된 이메일을 입력하였습니다");
		}

	}
}
