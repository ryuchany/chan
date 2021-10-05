package realnumber;

import java.lang.*;

public class test06 {
	public static void main(String[] args) {
// BMI(체질량지수)는 다음과 같은 공식으로 계산 합니다.
// 예를 들어 키가 180cm, 체중이 80kg인 사람의 BMI를 계산하면 다음과 같습니다.
// BMI = 80kg / (1.8m * 1.8m) = 24.69....
// 키 190cm, 체중 105kg인 사람의 BMI를 계산하여 출력하세요
		
		//입력
		int height = 190;
		int weigh = 105;

		//처리
		double m = (double) height /100;
		double bmi = weigh / (m * m);
		
		//출력
		System.out.println(bmi);

		
	}
}