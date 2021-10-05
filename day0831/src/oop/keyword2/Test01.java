package oop.keyword2;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("제목을 입력하세요 : ");
		String title = sc.next();
		System.out.print("폭을 입력하세요 : ");
		int width = sc.nextInt();
		System.out.print("높이를 입력하세요 : ");
		int height = sc.nextInt();
		sc.close();

		Screen a = new Screen(title, width, height);
		a.showInfo();

	}
}
