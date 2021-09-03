package oop.inherit6;

public class Test01 {
	public static void main(String[] args) {
		PPT f1 = new PPT("test.pptx", 1200L);
		f1.execute();

		AVI f2 = new AVI("test.avi", 10000L);
		f2.execute();
	}
}