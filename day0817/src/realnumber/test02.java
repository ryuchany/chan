package realnumber;

import java.lang.*;

public class test02 {
	public static void main(String[] args) {
		//다음 주어진 국어점수, 영어점수, 수학점수를 이용하여 총점과 평균을 구하여 출력
		//국어 : 85점, 영어 : 90점, 수학 : 90점

		//입력
		int korean = 85;
		int english = 90;
		int math = 90;
		
		//처리
		int sum = korean+english+math;
		double avg = sum/3.0;
		
		//출력
		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + avg);
		
	}
}