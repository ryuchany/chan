package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test04_4 {
	public static void main(String[] args) {

		String[] data = new String[] {"피카츄", "라이츄", "파이리", "꼬부기", "버터플"};

		//data를 "내림차순" 정렬해서 화면에 출력해보세요
		//= 참고하실 명령은 String class의 compareTo() 입니다.
		Comparator<String> c  = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) < 0) {
					return 1;
				}
				else if(o1.equals(o2)) {
					return 0;
				}
				else {
					return -1;
				}
			}
		};
		Arrays.sort(data, c);

		System.out.println(Arrays.toString(data));

	}
}
