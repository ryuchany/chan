package api.util.arrays;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
//		Arrays 클래스 : 배열에 대한 처리를 도와주는 클래스

		int[] arr = new int[] {30, 50, 20, 10, 40};

//		출력
		System.out.println(Arrays.toString(arr));

//		채우기
		Arrays.fill(arr, 0);

		System.out.println(Arrays.toString(arr));

	}
}
