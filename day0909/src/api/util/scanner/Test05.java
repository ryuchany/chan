package api.util.scanner;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//Scanner 의 특수기능 : 구분자(delimiter) 설정
		//= Scanner는 기본 구분자가 공백이기 때문

		String colors = "빨강/주황/노랑/초록/파랑/남색/보라";

		Scanner sc = new Scanner(colors);
		sc.useDelimiter("/");//슬래시(/)를 구분자로 인지하고 읽어라!

		while(sc.hasNext()) {
			System.out.println(sc.next());
		}

		sc.close();
	}
}
