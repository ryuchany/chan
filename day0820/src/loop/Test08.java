package loop;

//import java.lang.*;

public class Test08 {
	public static void main(String[] args) {
//1부터 99사이에 있는 "5가 들어간 숫자"를 출력
		for (int i = 1; i < 100; i++) {
			boolean first = i / 10 == 5; // 10의 자리가 5;
			boolean second = i % 10 == 5; // 1의 자리가 5;
			if (first || second) {
				System.out.println("i = " + i);
			}
		}

	}
}
