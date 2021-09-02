package oop.inherit3;

public class Test01 {

	public static void main(String[] args) {

		Chrome b1 = new Chrome();
		b1.setUrl("https://www.google.com");
		System.out.println(b1.getUrl());
		b1.refresh();
		b1.move();
		b1.develop();
		b1.chromeStore();

		Edge b2 = new Edge();
		b2.setUrl("https://www.google.com");
		System.out.println(b2.getUrl());
		b2.refresh();
		b2.move();
		b2.fullScreeen();

		Whale b3 = new Whale();
		b3.setUrl("https://www.google.com");
		System.out.println(b3.getUrl());
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
	}

}
