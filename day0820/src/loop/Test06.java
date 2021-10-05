package loop;

//import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		// 1부터 10까지 존재하는 짝수를 출력하세요

		for (int i = 2; i <= 10; i = i + 2) {
			System.out.println("i = " + i);

			System.out.println("-----------------");

			for (int b = 1; b <= 10; b++) {
				if (b % 2 == 0) {
					System.out.println("i = " + b);
				}
			}
		}
	}
}