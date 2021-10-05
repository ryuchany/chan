package loop;

//import java.lang.*;
public class Test10 {
	public static void main(String[] args) {
//Q : 1부터 10 사이의 짝수 개수를 구하여 출력

		int count = 0; // 계수기 역할을 수행할 변수를 0으로 설정
		int total = 0; // 누적합계 계산을 위한 변수를 0으로 설정

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
				count++;
				total += i;
			}
		}
		System.out.println("count = " + count);
		System.out.println("total= " + total);

	}
}
