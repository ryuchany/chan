package array2d;

public class Test5_1 {
	public static void main(String[] args) {
		// 배열 생성
		int[][] data = new int[5][5];// 5칸짜리 1차원배열을 5개 묶었다 = 5줄 5칸

		// 초기화 : 위치를 기준으로 반복하며 값을 초기화
		//= [0][0] 부터 [4][4] 까지 데이터를 추가
		int count = 1;
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				System.out.println(i+"번 줄 , "+k+"번 칸에 "+count+"를 대입합니다");
				//data[i][k] = 5 * i + k + 1;
				data[i][k] = count;
				count++;
			}
		}

		// 출력
		for (int i = 0; i < data.length; i++) {// 줄반복
			for (int k = 0; k < data[i].length; k++) {// 칸반복
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}