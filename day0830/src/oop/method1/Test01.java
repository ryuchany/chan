package oop.method1;

public class Test01 {

	public static void main(String[] args) {

		Mart a = new Mart();
		Mart b = new Mart();
		Mart c = new Mart();

		a.init("A00001", "참이슬", "주류", 1200);
		b.init("A00002", "처음처럼", "주류", 1300);
		c.init("B00001", "고무장갑", "생필품", 2000);

		a.showInfo();
		b.showInfo();
		c.showInfo();

	}

}
