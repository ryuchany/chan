package array;

public class Test09 {

	public static void main(String[] args) {
		// 우리반 학생 10명의 시험점수는 다음과 같습니다.
		// 95점, 82점, 77점, 69점, 75점, 62점, 76점, 77점, 85점, 93점
		// 우리반에서 가장 높은 점수를 구하여 출력
		// 우리반에서 가장 낮은 점수를 구하여 출력
	

		// 입력(준비)
		int[] score = new int[] { 95, 82, 77, 69, 75, 62, 76, 77, 85, 93 };

		// 1 최대값 찾기
		// (1)맨 앞에 있는 점수가 가장 큰 점수일 것이라고 가정을 하고 시작
		// (2) 그 뒤에 있는 데이터들과 비교하여 더 큰 데이터가 나오면 갱신
		// (3) 모든 과정이 종료된 뒤 남은 데이터가 최대값

		// (1)
		int max = score[0];

		// (2)
		// 최대 구하기
		for (int i = 1; i < score.length; i++) {
			if (max < score[i]) { // max 보다 더 큰 데이터가 score에 존재한다면
				max = score[i]; // max 를 현재의 점수( score[i]로 변경(갱신)한다.
			}
		}

		// (3)
		// 최대 출력
		System.out.println("최고 점수 = " + max + "점");

		// 최소 초기 세팅
		int min = score[0];

		// 최소 구하기
		for (int i = 1; i < score.length; i++) {
			if (min > score[i]) {
				min = score[i];
			}
		}
		// 최소 출력
		System.out.println("최저 점수 = " + min + "점");

	}
}
