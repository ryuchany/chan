package api.util.random;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {

		Random r = new Random();

		int dice = r.nextInt(6) + 1;
		System.out.println("dice = " + dice);

		System.out.println(r.nextInt());//무작위 int 범위 내에서의 값 1개 반환
		System.out.println(r.nextBoolean());
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		System.out.println(r.nextDouble());
		System.out.println(r.nextGaussian());//정규분포
	}
}
