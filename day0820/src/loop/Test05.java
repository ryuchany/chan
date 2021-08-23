package loop;
import java.lang.*;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		// Q : 사용자 이름을 입력받아 출력하는 것을 5번 수행하는 프로그램을 구현
		// 주의 : 도구는 반복문 안에서 만들지 않도록 한다

		Scanner sc = new Scanner(System.in);

		// for(int i = 1 ; i <= 5 ; i++) {
		for (int i = 0; i < 5; i++) {
			// 1번의 이름을 입력받아 출력하는 코드

			System.out.println("이름 입력");
			String name = sc.next();

			System.out.println("이름 = " + name);
		}

		sc.close();

	}
}