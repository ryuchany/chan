package api.lang.wrapper;

public class Test04 {
	public static void main(String[] args) {
		// int와 Integer의 결정적인 차이 : null
		// = null은 "참조형" 데이터에서 "객체"가 없음을 의미하는 단어
		// = int는 "원시형"이므로 null을 보관할 수 없다
		// = 혹시라도 null이라는 데이터가 발생할 수 있는 상황이라면 int는 절대로 사용하면 안된다

		// int a= null; // 안됨
		Integer a = null;
		System.out.println("a = " + a);
		int b = a;
		System.out.println("b = " + b);
	}
}
