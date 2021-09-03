package oop.inherit9;

public class Triangle extends Polygon {

	public Triangle(int width, int height) {
		super(width, height);
	}

	@Override
	public double area() {
		return width * height / 2.0;
	}

}
