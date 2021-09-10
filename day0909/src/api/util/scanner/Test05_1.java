package api.util.scanner;

import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		//Scanner 의 특수기능 : 구분자(delimiter) 설정
		//= 구분자를 정규표현식(Regex)로 설정 가능
		//= next()의 구분 기준이 재설정되며 nextLine()은 변하지 않는다

		String colors = "빨강+주황,노랑?초록/파랑=남색-보라";

		Scanner sc = new Scanner(colors);
//		sc.useDelimiter("더하기 또는 콤마 또는 물음표 또는 슬래시 또는 등호 또는 대시");
//		sc.useDelimiter("(\\+|,|\\?|\\/|=|-)");
		sc.useDelimiter("[+,?/=-]");

		while(sc.hasNext()) {
			System.out.println(sc.next());
		}

		sc.close();
	}
}
