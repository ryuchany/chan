package random;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		// Random(랜덤)
		// = 무작위 데이터
		// = 다음에 뭐가 나올지 예측할 수 없는 데이터
		// = 로또, 주사위
		// = 프로그래밍에서 확률적인 처리가 가능하도록 만들어주는 기술
		// = 프로그래밍에서는 랜덤한 "정수"를 추첨하여 사용하는 경우가 많다

		// 추첨 방법
		// 1. Math.random() 명령을 사용하는 방법
		// = 0 이상 1 미만의 double 데이터를 무작위로 추첨하는 명령
		// = 0.xxxxx 가 나오는 명령
		// 2. Random 이라는 도구를 사용하는 방법

		// ex : 1부터 10사이의 정수를 추첨
		double a = Math.random(); // 0 이상 1미만 double
		double b = a * 10; // 0 이상 10미만 double
		int c = (int) b; // 0 이상 10 미만 int
		int d = c + 1; // 0 이상 11 미만 int (원하는 범위)

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);

		// Math.random()을 이용하여 랜덤값을 뽑는 공식
		// int number =(int)(Math.random()*개수) + 시작;
		// = Java는 1부터 10까지라고 표현하지 않고 1부터 10개라고 표현한다.
		// = 만약 10부터 99까지라면 Java는 10부터 90개라고 현한다.
		int number = (int) (Math.random() * 45) + 1;
		System.out.println("number = " + number);

		// Random을 이용해서 랜덤값을 뽑는 방법
		Random r = new Random();
		int number2 = r.nextInt(45) + 1;
		System.out.println("number2 = " + number2);
	}
}
