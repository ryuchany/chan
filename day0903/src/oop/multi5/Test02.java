package oop.multi5;

public class Test02 {
	public static void main(String[] args) {
		IntBox box1 = new IntBox();
		box1.setValue(100);
		System.out.println(box1.getValue());

		ElectronicBox box3 = new ElectronicBox();
		Computer c = new Computer("슈퍼컴퓨터");
		box3.setValue(c);

		System.out.println(box3.getValue());
		box3.getValue().on();
		box3.getValue().off();
	}
}

