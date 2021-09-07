package api.lang.wrapper;

public class Test02 {
	public static void main(String[] args) {
		// Q : int가 있는데 Integer는 왜 필요한가? 뭐가 다른가?
		// A : int가 필요한 상황도 있고, Integer가 필요한 상황도 있다

		// int가 필요한 상황(ex : 10 + 20을 계산)
		int a1 = 10;
		int a2 = 20;
		int a3 = a1 + a2;
		System.out.println(a3);

		Integer b1 = new Integer(10);
		Integer b2 = new Integer(20);
		Integer b3 = Integer.sum(b1, b2);
		System.out.println(b3.toString());

		// Integer가 필요한 상황(ex : 100을 2진수로 변환)
		int c = 100;
		String s = "";
		for (int i = c; i > 0; i /= 2) {
			s = i % 2 + s;
		}
		System.out.println(s);
		System.out.println(Integer.toBinaryString(c));

	}

}
