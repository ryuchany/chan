package oop.inherit8;

public abstract class Galaxy extends Phone {

	public Galaxy(String number, String color) {
		super(number, color);
	}

	public Galaxy(String color) {
		super(color);
	}

	public abstract void samsungPay();
}
