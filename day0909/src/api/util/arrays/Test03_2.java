package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test03_2 {
	public static void main(String[] args) {
		Integer[] data = new Integer[] {30, 50, 20, 10, 40};

		//람다(Lambda) 표현식 : 
		//= 추상메소드가 하나뿐인 인터페이스라면 간단한 정보만 알려주고 나머지는 추리하도록 지시 가능
		//= 추상 클래스는 안됩니다
		Comparator<Integer> c = (o1, o2) -> {
			return o2 - o1;
		};
		Arrays.sort(data, c);

		System.out.println(Arrays.toString(data));
	}
}
