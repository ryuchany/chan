package array2d;

public class Test03 {

	public static void main(String[] args) {
		// 2차원 배열의 필요성
		// ex : 3개반에서 각 3명의 학생에 대한 성적 정보
		// - 0차원 : 변수 9개 (9명의 성적 정보)
		// - 1차원 : 1차원배열 3개 (3개반의 성적 정보)
		// - 2차원 : 2차원배열 1개 (1개 학년의 성적 정보)

		// 생성
		int[][] score = new int[][] { 
			{ 70, 80, 80 }, 
			{ 60, 90, 50 }, 
			{ 100, 80, 40 } 
		};

		//(score) -----> 	(+0) 	-----> 	[ 70 ] [ 80 ] [ 80 ] 
		//							(+1) 	----->	[ 60 ] [ 90 ] [ 50 ]
		//							(+2) 	----->	[ 100 ] [ 80 ] [ 40 ]

		//출력
		for(int i = 0 ; i < score[0].length ; i++) {
			System.out.print(score[0][i]);
			System.out.print("\t");
		}
		System.out.println();

		for(int i = 0 ; i < score[1].length ; i++) {
			System.out.print(score[1][i]);
			System.out.print("\t");
		}
		System.out.println();

		for(int i = 0 ; i < score[2].length ; i++) {
			System.out.print(score[2][i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
