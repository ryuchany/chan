package api.util.random;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		//시드(SEED)란 무엇인가?
		//= 랜덤값을 만들어내기 위한 계산의 시작값을 시드라 함

		Random r = new Random();

		r.setSeed(1L);
		int a = r.nextInt();
		r.setSeed(1L);
		int b = r.nextInt();

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
