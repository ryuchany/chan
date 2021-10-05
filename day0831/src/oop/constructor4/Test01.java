package oop.constructor4;

public class Test01 {

	public static void main(String[] args) {
		Room a = new Room("스탠드다드룸", 4, 100000, 200000, 250000);
		Room b = new Room("슈페리어룸", 4, 150000, 250000, 300000);
		Room c = new Room("디럭스룸", 6, 300000, 450000, 550000);
		Room d = new Room("프리미엄룸", 8, 1000000);

		a.showInfo();
		b.showInfo();
		c.showInfo();
		d.showInfo();

	}
}
