package array;

public class Test10 {

	public static void main(String[] args) {
		// 우리반 학생 10명의 시험점수는 다음과 같습니다.
		// 95점, 82점, 77점, 69점, 75점, 62점, 76점, 77점, 85점, 93점
		// 우리반에서 가장 높은 점수인 학생의 데이터 위치를 구하여 출력
		// 우리반에서 가장 낮은 점수인 학생의 데이터 위치를 구하여 출력

		int[] score = new int[] { 95, 82, 77, 69, 75, 62, 76, 77, 85, 93 };

		// 찾아야 하는 정보는 값이 아니라 위치(index)
		// 맨 앞 위치가 가장 큰 점수가 있는 위치일 것이라고 가정을 하고 시작
		// 그 뒤에 있는 데이터들과 비교하여 더 큰 데이터가 나오면 위치 갱신
		// 모든 과정이 종료된 뒤 남은 데이터가 최대값의 위치

		int maxIndex = 0;

		for (int i = 1; i < score.length; i++) {
			if (score[maxIndex] < score[i]) {
				maxIndex = i;
			}
		}

		System.out.println("최대값 위치 = " + maxIndex);
		// 배열의 특성상 위치를 알면 데이터도 알 수 있다.
		System.out.println("최대값 = " + score[maxIndex]);

		int minIndex = 0;
		for (int i = 1; i < score.length; i++) {
			if (score[minIndex] > score[i]) {
				minIndex = i;
			}
		}

		System.out.println("최대값 위치 = " + minIndex);
		// 배열의 특성상 위치를 알면 데이터도 알 수 있다.
		System.out.println("최대값 = " + score[minIndex]);

	}
}
