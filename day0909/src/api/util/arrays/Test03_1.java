package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test03_1 {
	public static void main(String[] args) {
		Integer[] data = new Integer[] {30, 50, 20, 10, 40};

		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Arrays.sort(data, c);

		System.out.println(Arrays.toString(data));
	}
}
