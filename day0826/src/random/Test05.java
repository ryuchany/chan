package random;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {

		//배열을 이용해서 데이터를 저장~
		Random r = new Random();
		int[] dice = new int[10];

		for(int i=0; i < dice.length; i++) {
			dice[i] = r.nextInt(6) + 1;//1부터 6개
		}

		//출력
		for(int i=0; i < dice.length; i++) {
			System.out.println("주사위 : "+dice[i]);
		}

		//평균 = 합계 / 개수 = 합계 / data.length
		int total = 0;
		for(int i=0; i < dice.length; i++) {
			total += dice[i];
		}
		float average = (float)total / dice.length;
		System.out.println("평균 주사위 : "+average);

		//처리 : 삽입정렬
		for(int k=0; k < dice.length; k++) {
			int backup = dice[k];//백업 데이터
			int location = k;//삽입 위치

			for(int i=k-1; i >= 0; i--) {
				if(backup > dice[i]) {//backup보다 data[i]가 더 크다면
					dice[i+1] = dice[i];//데이터(data[i])를 우측으로 1칸 이동
					location--;//위치(location) 1 감소
				}
			}
			dice[location] = backup;//백업 데이터를 목적지(location) 위치에 삽입
		}
		//출력
		for(int i=0; i < dice.length; i++) {
			System.out.println("주사위 : "+dice[i]);
		}

		//주사위 값별 빈도(카운트) 측정
		// -> 주사위 값이 6종류니까 카운트 변수도 6개가 필요 -> 카운트 배열 1개로 처리 가능
		//int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
		int[] count = new int[6];//(count) -----> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] 

		for(int i=0; i < dice.length; i++) {
			int d = dice[i];
			count[d-1]++;
		}

		for(int i=0; i < count.length; i++) {
			System.out.println((i+1) + " 나온 횟수 : "+count[i]);
		}
	}
}
