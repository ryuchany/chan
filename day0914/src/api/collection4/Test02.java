package api.collection4;

import java.util.Stack;

public class Test02 {
	public static void main(String[] args) {
//		Stack 형식의 저장소를 사용하면 "이력 관리"를 할 수 있다.
//		되돌리기 명령 실행 시 pop() 을 통하여 나온 데이터를 이용하여 어떤 처리를 수행할 수 있다.

		Stack<String> history = new Stack<>();

		history.push("https://www.google.com");
		history.push("https://www.naver.com");
		history.push("https://www.daum.net");

		System.out.println(history.pop());
		System.out.println(history.pop());
		System.out.println(history.pop());
	}
}
