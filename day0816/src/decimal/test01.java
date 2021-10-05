package decimal; //현재 이 파일의 위치가 첫 줄에 나와야 한다.

import java.lang.*;

public class test01 {
	public static void main(String[] args) {
		// 정수를 변수에 저장
		//1. 변수의 형태마다 정해진 크기가 있으며 넘어갈 수 없다.
		//2. 정수 계산시 범위가 초과되면 순환한다.
		//3. 모든 정수의 계산은 최소 int 이상의 정수 결과가 나온다.
		// = 정수끼리 계산하면 정수가 나온다.
		
		//1
		//byte a = 1000; X
		
		byte a = 100;
		System.out.println(a);
		
		int b = 2100000000;
		System.out.println(b);
		
		long c = 2500000000L; // long은 L표시를 추가한다.
		System.out.println(c);
		
		
		//2
		//int d = 1234567 * 1234567;
		long d = 1234567L * 1234567L;
		System.out.println(d);
		
		int e = 2147483647 + 1;
		System.out.println(e);
		
		//3
		System.out.println(10 + 20);//30
		System.out.println(10 - 20);//-10
		System.out.println(10 * 20);//200
		System.out.println(10 / 20);//0
		System.out.println(10 % 20);//10
	}
}
