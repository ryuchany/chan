package array;

public class Test8_1 {

	public static void main(String[] args) {

		int[] score = new int[] { 95, 82, 77, 69, 75, 62, 76, 77, 85, 93 };

		// 추가문제 : ranking 배열에 "모든 학생의 순위" 점수 순서대로 계산하여 저장 후 점수와 연결하여 출력
		// ex : ranking[0]에는 score[0] 학생의 순위를 구하여 저장
		int[] ranking = new int[score.length];// score 길이만큼 ranking 생성

		// ranking[k] 에 들어갈 순위를 계산
		for (int k = 0; k < score.length; k++) {
			ranking[k] = 1;
			for (int i = 0; i < score.length; i++) {
				if (score[k] < score[i]) {
					ranking[k]++;
				}
			}
		}

		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 = " + score[i] + "점, 등수 = " + ranking[i] + "등");
		}
	}
}
