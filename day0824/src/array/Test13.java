package array;

public class Test13 {

	public static void main(String[] args) {
		// 다음과 같은 데이터를 배열에 저장한 뒤 요구사항에 맞게 코드를 구현하세요
		// 데이터 : 30, 50, 20, 10, 40
		// 1. 배열을 순서대로 출력
		// 2. 배열의 모든 데이터 위치를 반대로 변경하여 출력

		int[] data = new int[] { 30, 50, 20, 10, 40 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}

		System.out.println();

		for (int i = 0; i < data.length / 2; i++) {
			int temp = data[i];
			data[i] = data[data.length - 1 - i];
			data[data.length - 1 - i] = temp;
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}
