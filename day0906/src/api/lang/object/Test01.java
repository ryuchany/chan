package api.lang.object;

import java.util.Random;

//import java.lang.Object;//java.lang은 작성하지 않아도 됨
public class Test01 {
	public static void main(String[] args) {
		// Object 객체 생성
		Object a = new Object();
		Object b = new Object();
		// Object c = new Object(100);//지원하지 않는 생성자

		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		System.out.println(a.toString());
		System.out.println(b.toString());

		// Q : java.util.Random이라는 클래스 객체를 아무 방법이나 1개 사용하여 생성한 뒤 toString() 호출
		Random c = new Random();
		System.out.println(c.hashCode());
		System.out.println(c.toString());
	}
}
