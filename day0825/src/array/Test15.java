package array;

public class Test15 {
	public static void main(String[] args) {

		// 입력
		int[] data = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };

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

		// 선택 정렬(SELECTION SORT)
		for (int k = 0; k < data.length - 1; k++) {
			// 최소값 찾기
			int minIndex = k;// k번 위치가 가장 작다고 생각
			for (int i = k + 1; i < data.length; i++) {
				if (data[minIndex] > data[i]) {// 더 작은 데이터가 발견되었다면
					minIndex = i;// 위치 정보를 변경
				}
			}

			// 교체(swap) : minIndex와 k번 위치의 데이터를 교체
			int temp = data[minIndex];
			data[minIndex] = data[k];
			data[k] = temp;
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
