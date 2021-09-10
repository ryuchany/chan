package api.util.scanner;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//키보드 입력 시 주의사항
		//= next() 종류와 nextLine() 을 섞어서 사용하면 문제가 발생한다
		//= next()는 공백(띄어쓰기, 개행)을 인식하는 명령(공백을 읽을 때 제거함)
		//= nextLine()은 개행문자만 인식하는 명령(개행문자를 읽고 나서 제거함)
		//= 만약 next() 계열 명령 이후에 nextLine()을 사용해야 할 경우 초기화를 수행하여 개행문자를 제거

		Scanner sc = new Scanner(System.in);

		System.out.println("입력");
		String a = sc.next();
		sc.nextLine();//남아있는 개행문자를 정리하기 위하여 읽는 명령을 추가로 삽입
		String b = sc.nextLine();

		sc.close();

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
