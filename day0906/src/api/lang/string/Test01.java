package api.lang.string;

public class Test01 {
	public static void main(String[] args) {

//		1. String클래스의 생성자를 이용하여 "Hello World"라는 글자가 담긴 객체를 a라는 이름으로 생성해보세요
//		2. String클래스의 생성자를 이용하여 "hello world"라는 글자가 담긴 객체를 b라는 이름으로 생성해보세요

//		String a = "Hello World";
//		String b = "hello world";
		String a = new String("Hello World");
		String b = new String("hello world");

//		3. a와 b의 글자수를 구하여 출력해보세요
		System.out.println("a의 글자 수 = " + a.length());
		System.out.println("b의 글자 수 = " + b.length());

//		4. a의 3번째 글자를 추출하여 출력해보세요
//		= 문자열은 char의 모음이며, 위치는 +0부터 시작
		System.out.println(a.charAt(2));

//		5. a와 b가 "동등"한지 비교하세요
		System.out.println(a == b);// 백날 비교해도 false(절대로 true가 나올 수 없음) - 동일비교
		System.out.println(a.equals(b));// 글자값 일치 검사(대소문자를 구분) - 동등비교

//		6. a와 b가 "대소문자를 무시하고 동등"한지 비교해보세요
		System.out.println(a.equalsIgnoreCase(b));

	}
}