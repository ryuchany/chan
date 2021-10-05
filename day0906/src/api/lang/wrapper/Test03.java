package api.lang.wrapper;

public class Test03 {
	public static void main(String[] args) {
		// Q : int와 Integer는 서로 변환이 가능합니까?
		// A : 반드시 구분해야하는 경우가 아니라면 구분하지 않고 섞어써도 된다

		int a = 10;
		Integer b = 10; // int ---> Integer (원시형 -> 참조형) : auto-boxing
		int c = new Integer(10); // Integer ---> int (참조형 -> 원시형) : auto-unboxing

		Integer a1 = 10;
		Integer a2 = 20;
		Integer a3 = a1 + a2;
		System.out.println(a3);

	}
}
