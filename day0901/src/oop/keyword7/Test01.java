package oop.keyword7;

public class Test01 {
	public static void main(String[] args) {
		
		Sonata a = new Sonata("현대", "블랙", 20000000);
		Sonata b = new Sonata("현대", "그레이", 20000000);
		Sonata c = new Sonata("현대", "레드", 19000000);

//		System.out.println(a.toString());
//		System.out.println(b.toString());
//		System.out.println(c.toString());

//		a.setCompany("기아");//잘못된 static 이용법(경고 발생)
		Sonata.setCompany("기아");// 정확한 static 이용법
		a.setColor("퍼플");// 문제없음
		a.setPrice(10000000);// 문제없음

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
