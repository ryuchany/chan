package oop.inherit9;

public abstract class Polygon extends Shape {

	protected int width;
	protected int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Polygon(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
}
