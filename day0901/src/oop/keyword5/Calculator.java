package oop.keyword5;

public class Calculator {

	public static int multiple(int left, int right) {
		return left * right;
	}

	public static int square(int n) {
		return n * n;
	}

	public static int square(int n, int m) {
		int result = 1;
		for (int i = 0; i < m; i++) {
			result *= n;
		}
		return result;
	}

	public static float triangle(int width, int height) {
		int rect = width * height;
		float result = rect / 2f;
		return result;
	}

	public static float circle(int radius) {
		return 3.14f * radius * radius;
	}

	public static int random(int a, int b) {
		int n = b - a + 1;
		int number = (int) (Math.random() * n) + a;
		return number;
	}

}
