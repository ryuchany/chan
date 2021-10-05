package oop.inherit9;

public class Test01 {
	public static void main(String[] args) {

		Circle s1 = new Circle(5);
		System.out.println(s1.area());

		Triangle s2 = new Triangle(5, 7);
		System.out.println(s2.area());

		Rect s3 = new Rect(5, 7);
		System.out.println(s3.area());

	}
}
