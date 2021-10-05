package api.lang.string;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] no = new String[] { "주옥", "신발끈", "개나리", "십장생", "수박씨", "시베리아", "쌍화차", "가습기", "개불", "게새우" };

		System.out.println("채팅을 입력하세요");

		String chat = sc.nextLine();

		sc.close();

		for (int i = 0; i < no.length; i++) {

			chat = chat.replace(no[i], "***");
		}

		System.out.println("사용자 : " + chat);

	}

}
