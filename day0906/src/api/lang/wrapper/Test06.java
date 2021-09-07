package api.lang.wrapper;

public class Test06 {
	public static void main(String[] args) {
		Integer a = 10; // int --> Integer : auto-boxing
		Integer b = 10; // int --> Integer : auto-boxing
		Integer c = new Integer(10);
		Integer d = new Integer(10);

		System.out.println(a == b); // true
		System.out.println(b == c); // false
		System.out.println(c == d); // false
		System.out.println(d == a);// false

		System.out.println(a.equals(b)); // true
		System.out.println(b.equals(c)); // true
		System.out.println(c.equals(d)); // true
		System.out.println(d.equals(a)); // true
	}

}
