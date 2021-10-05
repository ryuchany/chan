package oop.inherit9;

public class Test02 {
	public static void main(String[] args) {
		//동적 타입(다형성)
		Shape s1 = new Circle(5);
		System.out.println(s1.area());

		Shape s2 = new Rect(5, 7);
		System.out.println(s2.area());

		Shape s3 = new Triangle(5, 7);
		System.out.println(s3.area());
	}
}
