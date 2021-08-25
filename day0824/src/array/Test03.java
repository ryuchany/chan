package array;

public class Test03 {

	public static void main(String[] args) {
		// 변수 : 단일 데이터 저장소
		// 배열 : 다중 데이터 저장소

		// = 배열은 변수만으로 처리하기 어려워서 나온 개념
		// = 어떤 상황에서 변수로 처리하는 것이 어려운지 파악하는 것이 중요!

		// 10, 20, 30, 40, 50 이라는 숫자를 저장 및 합계계산 후 출력
		int[] arr = new int[5];// (arr) ------> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ]

		// arr = 10;//말이 안되는 코드
		int value = 10;
		for (int i = 0; i < 5; i++) {
			arr[i] = value;
			value += 10;
		}

		// int total = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
		int total = 0;
		for (int i = 0; i < 5; i++) {
			total += arr[i];
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}

		System.out.println("total = " + total);
	}
}
