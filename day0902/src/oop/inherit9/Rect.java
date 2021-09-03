package oop.inherit9;

public class Rect extends Polygon {

	public Rect(int width, int height) {
		super(width, height);
	}

	@Override
	public double area() {
		return width * height;
	}

}
