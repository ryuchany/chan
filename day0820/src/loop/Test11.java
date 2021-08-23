package loop;

//import java.lang.*;

public class Test11 {
	public static void main(String[] args) {
//1부터 99사이에 있는 "5가 들어간 숫자"를 출력 하고 숫자 카운트, 합계도 출력
		int total = 0;
		int count = 0;
		for (int i = 1; i < 100; i++) {
			boolean first = i / 10 == 5; // 10의 자리가 5;
			boolean second = i % 10 == 5; // 1의 자리가 5;
			if (first || second) {
				System.out.println("i = " + i);
				count++;
				total += i;

			}
		}

		System.out.println("카운트 = " + count);
		System.out.println("합계 = " + total);
	}
}
