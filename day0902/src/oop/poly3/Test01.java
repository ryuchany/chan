package oop.poly3;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("휴대폰 종류를 입력하세요\n( 갤럭시21s | 갤럭시폴드3 | 아이폰11 | 아이폰12 )");
		String model = sc.next();
		System.out.println("기능을 입력하세요\n( 사진촬영 | 갤러리보기 | 통화 | 문자 )");
		String menu = sc.next();

		sc.close();

		Main phone = null;

		switch (model) {
		case "갤럭시21s":
			phone = new Galaxy21s();
			break;
		case "갤럭시폴드3":
			phone = new GalaxyFold3();
			break;
		case "아이폰11":
			phone = new IPhone11();
			break;
		case "아이폰12":
			phone = new IPhone12();
			break;
		default:
			System.out.println("없는 종류입니다");
			break;
		}

		switch (menu) {
		case "사진촬영":
			phone.camera();
			break;
		case "갤러리보기":
			phone.gallery();
			break;
		case "통화":
			phone.call();
			break;
		case "문자":
			phone.sms();
			break;
		default:
			System.out.println("없는 기능입니다");
			break;
		}

	}
}