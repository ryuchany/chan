package api.lang.string;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String id = sc.next();
		System.out.println("비밀번호 입력");
		String password = sc.next();
		sc.close();

//		boolean isLogin = 아이디가 admin이고 비밀번호가 master입니까?;
//		boolean isLogin = id == "admin" && password == "master";
//		boolean isLogin = id.equals("admin") && password.equals("master");
		boolean isLogin = id.equalsIgnoreCase("admin") && password.equals("master");
//		System.out.println("isLogin = " + isLogin);

		if (isLogin) {
			System.out.println("관리자님 로그인하셨습니다");
		} else {
			System.out.println("정보가 일치하지 않습니다");
		}

	}
}
