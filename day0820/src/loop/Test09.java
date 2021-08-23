package loop;

//import java.lang.*;

public class Test09 {
	public static void main(String[] args) {
//1부터 99사이에 있는 숫자를 이용하여 369게임을 실시한 결과를 출력
		// 369게임은 숫자에 3, 6, 9가 있다면 해당 개수만큼 박수를 치는게임
		// 시물레이션 결과를 예상하여 화면에 출력

		for (int i = 1; i < 100; i++) {
			boolean first = i / 10 == 3 || i / 10 == 6 || i / 10 == 9; // 10의 자리가 3, 6, 9;
			boolean second = i % 10 == 3 || i % 10 == 6 || i % 10 == 9; // 1의 자리가 3, 6, 9;
			if (!(first || second)) { // 10의자리, 1의자리에도 없는경우
				System.out.println(i);
			} else if (first && second) { // 3 6 9 가 두 개 있다면
				System.out.println("짝짝");
			} else { // 3 6 9 가 한개 있다면
				System.out.println("짝");
			}

		}

	}
}
