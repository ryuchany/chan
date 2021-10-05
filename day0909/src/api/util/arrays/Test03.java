package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test03 {
	public static void main(String[] args) {
//		Arrays를 이용한 정렬(sort)
		Integer[] data = new Integer[] {30, 50, 20, 10, 40};

//		Arrays.sort(data);//전체 오름차순 정렬
//		Arrays.sort(data, 1, 3);//부분 오름차순 정렬(1부터 3 전까지)

//		원시형은 정렬의 방식을 커스터마이징 할 수 없다
//		generic type에는 참조형만 작성할 수 있다.(int를 쓰고 싶다면 Integer라고 작성해야 한다)
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//(+는 순서교체, 0은 동일, -는 현상유지를 의미)
				//o1이 앞쪽에 있는 데이터, o2가 뒤쪽에 있는 데이터
				//= 오름차순이 되려면 앞에 있는 데이터(o1)가 뒤에 있는 데이터(o2)보다 작아야 합니다
				//= 내림차순이 되려면 앞에 있는 데이터(o1)가 뒤에 있는 데이터(o2)보다 커야 합니다

				/*
				if(o1 < o2) {//앞이 작으면
					return 1;//바꾸세요
				}
				else if(o1 > o2) {//앞이 크면
					return -1;//놔두세요
				}
				else {//같으면
					return 0;//같아요
				}
				*/
				return o2 - o1;
			}
		};
		Arrays.sort(data, c);//data라는 배열을 c라는 비교기준에 의해서 정렬해라!

		System.out.println(Arrays.toString(data));
	}
}
