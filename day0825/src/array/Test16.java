package array;

public class Test16 {
	public static void main(String[] args) {
		// 버블 정렬 (Bubble Sort)
		// 처리 1. 앞에서부터 현재 값과 바로 다음 (오른쪽) 의 값을 비교한다.
		// 2. 현재 값이 다음 값보다 크면 값을 교환한다.
		// 3. 다음 값으로 이동하여 해당 값과 그 다음 값을 비교한다.

		// 입력
		int[] data = new int[] { 30, 50, 20, 10, 40, 7, 5, 80, 25 };

		// 출력
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			if (i < data.length - 1) {// 마지막 데이터가 아니라면
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();

		// 처리 : 버블정렬
		for (int h = data.length - 1; h > 0; h--) {
			for (int k = 0; k < h; k++) {
				if (data[k] > data[k + 1]) {
					int temp = data[k];
					data[k] = data[k + 1];
					data[k + 1] = temp;
				}
			}
		}

		// 출력
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			if (i < data.length - 1) {// 마지막 데이터가 아니라면
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();

	}
}