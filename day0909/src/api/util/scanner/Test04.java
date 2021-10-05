package api.util.scanner;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		String song = "떳다떳다 비행기 날아라 날아라\n떳다떳다 비행기 우리비행기";
//		System.out.println(song);

//		.nextLine()	\n 전까지의 내용을 읽는 명령(\n은 버린다)		
		Scanner sc = new Scanner(song);

		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

		sc.close();
	}
}
