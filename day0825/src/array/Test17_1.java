package array;

import java.util.Arrays;

public class Test17_1 {
	public static void main(String[] args) {
		// 라이브러리 코딩으로 정렬 및 출력 진행
		int[] data = new int[] { 30, 50, 20, 10, 40 };

		System.out.println(Arrays.toString(data));

		Arrays.sort(data);

		System.out.println(Arrays.toString(data));
	}
}
