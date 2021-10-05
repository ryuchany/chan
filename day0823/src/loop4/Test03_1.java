package loop4;

import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {
//369게임 문제와 숫자에서 7개수세기 문제를 참고해서 아래 요구사항에 맞게 문제를 푸세요.
		// 1부터 1000까지 369게임을 하면 치게되는 박수 횟수를 계산하여 출력
		// 사용자에게 시작구간과 종료구간을 입력받아서 해당 구간에서의 박수 횟수를 계산하여 출력

		Scanner sc = new Scanner(System.in);
		System.out.print("시작 구간을 입력하세요 = ");
		int start = sc.nextInt();
		System.out.print("종료 구간을 입력하세요 = ");
		int end = sc.nextInt();

		int count = 0;
		for (int i = start; i <= end; i++) {
			boolean first = i / 100 == 3 || i / 100 == 6 || i / 100 == 9; // 100의 자리가 3, 6, 9;
			boolean second = (i % 100) / 10 == 3 || (i % 100) / 10 == 6 || (i % 100) / 10 == 9; // 10의 자리가 3, 6, 9;
			boolean third = i % 10 == 3 || i % 10 == 6 || i % 10 == 9; // 1의 자리가 3, 6, 9;

			boolean three = first && second && third; // 짝짝짝
			boolean two = (first && second) || (first && third) || (second && third); // 짝짝

			if (!(first || second || third)) {

			} else if (three) {// 3,6,9가 세 개 = 짝짝짝
				count += 3;
				System.out.println(i + "짝짝짝");
			} else if (two) {// 3,6,9가 두 개 = 짝짝
				count += 2;
				System.out.println(i + "짝짝");
			} else {// 3,6,9가 한 개 = 짝
				count++;
				System.out.println(i + "짝");
			}
		}
		sc.close();
		System.out.println(start + "에서 " + end + "까지");
		System.out.println("박수친 횟수 = " + count + "번");
	}
}