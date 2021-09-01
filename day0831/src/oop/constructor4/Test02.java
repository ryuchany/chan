package oop.constructor4;

public class Test02 {
	public static void main(String[] args) {
		// Test01을 배열로 풀이

		// int[] arr = new int[4];
		Room[] arr = new Room[4];

		arr[0] = new Room("스탠다드룸", 4, 100000, 200000, 250000);
		arr[1] = new Room("슈페리어룸", 4, 150000, 250000, 300000);
		arr[2] = new Room("디럭스룸", 6, 300000, 550000);
		arr[3] = new Room("프리미엄룸", 8, 1000000);

		arr[0].showInfo();
		arr[1].showInfo();
		arr[2].showInfo();
		arr[3].showInfo();
	}
}