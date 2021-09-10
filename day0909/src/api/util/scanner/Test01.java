package api.util.scanner;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//Scanner : 입력 클래스
		//= 원래 개발 목적이 키보드 입력용이 아니고 문자열 분해도구
		//= 키보드 입력용으로 쓰다 보니까 편하고 좋아서 모든 교재에서 이를 채택해서 사용할 뿐

		String song = "떳다떳다 비행기 날아라 날아라\n떳다떳다 비행기 우리비행기";
		System.out.println(song);

		//.hasNext()	더 읽을 내용이 있는지 판정하는 명령
		//.next()		공백 이전까지를 문자열로 읽어들이는 명령
		Scanner sc = new Scanner(song);
		while(true) {
			if(sc.hasNext() == false) {
				break;
			}
			System.out.println(sc.next());
		}
		sc.close();

	}
}
