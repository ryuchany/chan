package oop.keyword8;

public class Test01 {
		public static void main(String[] args) {
			Sonata.setCompany("현대");

			Sonata a = new Sonata("블랙", 20000000);
			Sonata b = new Sonata("그레이", 20000000);
			Sonata c = new Sonata("레드", 19000000);

//			System.out.println(a.toString());
//			System.out.println(b.toString());
//			System.out.println(c.toString());

			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
}
