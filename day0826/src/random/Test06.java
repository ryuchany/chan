package random;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		// 다음 요구사항에 맞게 프로그래밍 코드를 구현하세요

		// 1. 이번주 로또번호를 추첨한 결과를 배열에 저장하세요.
		// = 로또번호는 1부터 45 사이의 랜덤한 정수가 6개 추첨됩니다(보너스번호 제외)
		// = 로또번호는 중복이 발생할 수 없으므로 중복값이 발생하면 다시 추첨하도록 해야합니다.
		// 2. 결과를 오름차순으로 정렬하여 출력하세요.
		// 3. 1부터 45까지의 숫자가 각각 몇 번 추첨되었는지 카운트하여 출력하세요

		// 1 -> ?번
		// 2 -> ?번
		// 3 -> ?번
		// ...
		// 44 -> ?번
		// 45 -> ?번

		// 랜덤값 추첨 시 다음을 고려해야 한다.
		// 1. 복원추출 - 이미 추첨된 항목을 다시 포함하여 랜덤 추첨하는 방식(중복 발생)
		// 2. 비복원추출 - 이미 추첨된 항목을 제외하고 랜덤 추첨하는 방식(중복 발생)

		int[] lotto = new int[6];

		Random r = new Random();// 자동 import : 컨트롤+쉬프트+O

		// 추첨 시 중복제거 처리
		// = 현재위치(i)의 데이터를 추첨하며 처음(0)부터 현재위치 전(i-1) 까지 검사(k)
		// = 만약에 중복이 발생한다면 현재위치(i)가 증가하지 못하도록 만들어 재추첨을 실시
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;

			// 처음(0)부터 현재위치 바로앞(i-1)까지 반복하며 중복데이터를 검사
			for (int k = 0; k < i; k++) {
				if (lotto[i] == lotto[k]) {
					i--;// 위치증가가 일어나지 않도록 상쇄 처리
					break;// 성능 향상을 위한 처리(중복 데이터 발견 시 비교 즉시 종료)
				}
			}
		}

		// 처리 : 버블정렬
		for (int h = lotto.length - 1; h > 0; h--) {// 마지막 위치부터 1까지
			for (int k = 0; k < h; k++) {// h회차 반복문
				// System.out.println(k+" vs "+(k+1));
				if (lotto[k] > lotto[k + 1]) {
					int temp = lotto[k];
					lotto[k] = lotto[k + 1];
					lotto[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

		// 각각의 번호에 대한 카운트 측정
		// = 1부터 45까지 카운트해야하므로 카운트 변수가 45개 필요함
		int[] count = new int[45];

		for (int i = 0; i < lotto.length; i++) {
			int number = lotto[i];
			count[number - 1]++;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println((i + 1) + " - " + count[i] + "번");
		}

	}
}
