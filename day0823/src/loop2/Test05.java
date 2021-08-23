package loop2;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
//다음 요구사항에 맞는 프로그램을 while문을 이용하여 구현
		// 구구단 게임
		// 사용자에게 원하는 단수를 입력받는다
		// 입력받은 단을 기준으로 x1 부터 순차적으로 문제를 출제
		// 문제 출제후 사용자에게 정답을 입력받는다
		// 정답이 아닌 경우 게임 오버 출력후 종료
		// (추가) 위의 프로그램을 개조하여 총 3번까지 틀리면 게임 오버 처리 되도록 구현
		// (추가) 게임 오버 시 총 맞춘 문제수 * 100점을 계산하여 점수 출력
		// (추가) 콤보 시스템 도입 1콤보당 100점씩 추가, 최대 콤보수 출력

		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 단수를 입력하세요 = ");
		int number = sc.nextInt();
		int total = 0; // 콤보+맞춘수 점수
		int combo = 0; // 콤보
		int sum = 0; // 맞춘수
		int life = 3; // 목숨
		int i = 1; // 1단부터
		//int maxCombo = 0; // 최대 콤보수

		while (true) {
			System.out.print(number + " X " + i + " = ");
			int num = sc.nextInt();

			if (number * i == num) {
				i++;
				sum++;
				combo++;
				System.out.println(combo + "콤보!");
				total += combo * 100;
				//maxCombo ++ ;
			}

			else {
				System.out.println("땡!");
				combo = 0;
				life--;
				System.out.println("남은 기회가 " + life + "번 있습니다");
				if (life == 0) {
					break;
				}
			}
		}
		sc.close();
		System.out.println("Game over");
		System.out.println("총 맞춘 문제수 " + sum + "개");
		System.out.println("획득 점수 " + total + "점");
		//System.out.println("최대 콤보수 " + maxCombo + "개");

	}
}
