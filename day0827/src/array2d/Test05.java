package array2d;

public class Test05 {
	public static void main(String[] args) {

		// 배열 생성
		int[][] data = new int[5][5];// 5칸짜리 1차원 배열을 5개 묵었다 = 5줄 5칸

		
		// 초기화
		data[0][0] = 1;
		data[0][1] = 2;
		data[0][2] = 3;
		data[0][3] = 4;
		data[0][4] = 5;
		
		data[1][0] = 6;
		data[1][1] = 7;
		data[1][2] = 8;
		data[1][3] = 9;
		data[1][4] = 10;
		
		data[2][0] = 11;
		data[2][1] = 12;
		data[2][2] = 13;
		data[2][3] = 14;
		data[2][4] = 15;
		
		data[3][0] = 16;
		data[3][1] = 17;
		data[3][2] = 18;
		data[3][3] = 19;
		data[3][4] = 20;
		
		data[4][0] = 21;
		data[4][1] = 22;
		data[4][2] = 23;
		data[4][3] = 24;
		data[4][4] = 25;
		
		
		
		// 출력
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}

	}
}