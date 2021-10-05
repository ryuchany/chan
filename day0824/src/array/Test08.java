package array;

public class Test08 {

	public static void main(String[] args) {
		//우리반 학생 10명의 시험점수는 다음과 같습니다.
		//95점, 82점, 77점, 69점, 75점, 62점, 76점, 77점, 85점, 93점
		//우리반 학생들의 점수를 배열에 저장하고 출력
		//우리반 학생 중 80점 이상을 획등한 학생들의 숫자를 구하여 출력
		//우리반 평균을 구하여 출력
		//만약 전학생의 점수가 76점이라면 전학생의 등수는 몇등인지 계산하여 출력(사용자 입력도 가능)
		
		
		// 입력(준비)
		// int[] score = new int[10];
		int[] score = new int[] { 95, 82, 77, 69, 75, 62, 76, 77, 85, 93 };

		// 1. 전체 점수를 출력
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 = " + score[i]);
		}

		// 2. 80점 이상을 획득한 인원 수 출력(카운트)
		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 80) {
				System.out.println("80점 이상인 학생 = " + score[i]);
			}
		}

		// 3. 우리반 평균 출력
		// 평균 = 총점 / 인원수 = 총점 / score.length

		int total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}

		float average = (float) total / score.length;
		System.out.println("평균 = " + average);

		// 4. 전학생의 예상 등수 구하기
		int newScore = 76;
		int rank = 1;

		for (int i = 0; i < score.length; i++) {
			if (newScore < score[i]) {// 나보다 잘난놈을 발견했다면
				rank++;
			}
		}

		System.out.println("전학생 등수 = " + rank);

	}
}
