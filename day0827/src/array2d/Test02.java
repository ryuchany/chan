package array2d;

public class Test02 {

	public static void main(String[] args) {
		// 2차원 배열의 필요성
		// ex : 3개반에서 각 3명의 학생에 대한 성적 정보
		// - 0차원 : 변수 9개
		// - 1차원 : 1차원배열 3개
		// - 2차원 : 2차원배열 1개

		// 생성
		int[] score1 = new int[3]; // 첫 번째 반
		int[] score2 = new int[3]; // 두 번째 반
		int[] score3 = new int[3]; // 세 번째 반

		// 출력
		for (int i = 0; i < score1.length; i++) {
			System.out.print(score1[i]);
			System.out.print("\t");
		}
		System.out.println();
		
		for (int i = 0; i < score2.length; i++) {
			System.out.print(score2[i]);
			System.out.print("\t");
		}
		System.out.println();
		
		for (int i = 0; i < score3.length; i++) {
			System.out.print(score3[i]);
			System.out.print("\t");
		}
		System.out.println();

	}
}
