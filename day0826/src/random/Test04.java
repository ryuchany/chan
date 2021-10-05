package random;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		// 우리 게임에서는 이용자를 위해 랜덤박스 이벤트를 진행합니다.
		// 확률 공개 규정에 의해 공개된 확률은 다음과 같습니다
		// - 최상급 아이템 : 1%
		// - 상급 아이템 : 5%
		// - 중급 아이템 : 14%
		// - 일반 아이템 : 80%
		// 프로그램을 실행하면 위의 확률에 맞게 랜덤으로 하나의 랜덤박스 추첨 결과를 출력

		// 입력
		Random r = new Random();

		int box = r.nextInt(100) + 1;

		if (1 == box) {
			System.out.println("최상급 아이템");
		} else if (box <= 6) {
			System.out.println("상급 아이템");
		} else if (box <= 20) {
			System.out.println("중급 아이템");
		} else {
			System.out.println("일반 아이템 ");
		}
	}
}
