package api.util.arrays;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
//		Arrays 클래스 : 배열에 대한 처리를 도와주는 클래스

		int[] arr = new int[] {30, 50, 20, 10, 40};

//		20은 몇 번째 위치에 있습니까?
		int index = Arrays.binarySearch(arr, 210);
		System.out.println("index = " + index);
		if(index >= 0) {
			System.out.println("있어요");
		}
		else {
			System.out.println("없어요");
		}

	}
}
