package oop.total1;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String password = sc.next();
		System.out.print("닉네임 입력 : ");
		String nickname = sc.next();
		sc.close();

		User a = new User(id, password, nickname);
		a.showInfo();
	}
}
