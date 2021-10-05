package realnumber;

import java.lang.*;

public class test05 {
	public static void main(String[] args) {

		//입력
		int javaScore = 70;
		int databaseScore = 85;
		int count = 2;
		
		//처리 - 변환(cast) 연산을 활용해서 두 값 중 하나를 미리 실수로 변환 후 계산
		int sum = javaScore+databaseScore;
		float avg = sum/ (float) count;
		
		//출력
		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + avg);
		
	}
}