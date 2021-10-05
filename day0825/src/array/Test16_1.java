package array;

public class Test16_1 {
	public static void main(String[] args) {
		// 버블 정렬 (Bubble Sort)
		// 처리 1. 앞에서부터 현재 값과 바로 다음 (오른쪽) 의 값을 비교한다.
		// 2. 현재 값이 다음 값보다 크면 값을 교환한다.
		// 3. 다음 값으로 이동하여 해당 값과 그 다음 값을 비교한다.

		// 입력
		int[] data = new int[] { 3,44,38,5,47,15,36,26,27,2,46,4,19,50,48 };

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}

		System.out.println();
		int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
				count++;
			}
		}
		

		// 출력
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		System.out.println("카운트 = " + count);
	}
}