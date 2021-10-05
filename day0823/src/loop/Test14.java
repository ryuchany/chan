package loop;

import java.util.Scanner;

public class Test14 {
	public static void main(String[] args) throws Exception{
//요구사항
		// 사용자에게 '분'과'초를 정수 형태로 입력받습니다
		// 사용자가 입력한 시간부터 '0분 0초'가 될 때까지 1초씩 감소시켜가면서 화면에 메세지를 출력하세요
		// '0분 0초'가 되면 화면에 '시간이 다 되었습니다!' 라는 메세지를 함께 출력

		Scanner sc = new Scanner(System.in);
		System.out.println("분을 입력하세요.");
		int minute = sc.nextInt();
		System.out.println("초를 입력하세요.");
		int second = sc.nextInt();
		sc.close();

		int time = minute * 60 + second;
		for (int i = time; i >= 0; i--) {
			System.out.println(i/60 + "분 " + i%60+ "초 " + "후 알람이 울립니다.");
			Thread.sleep(1000L);
		}

		System.out.println("시간이 다 되었습니다!");

	}
}
