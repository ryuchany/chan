package array2d;

public class Test5_2 {
	public static void main(String[] args) {
		// 배열 생성
		int[][] data = new int[5][5];// 5칸짜리 1차원배열을 5개 묶었다 = 5줄 5칸

		// 초기화 : 값을 기준으로 반복하며 초기화
		//= 1부터 25까지 데이터를 추가
		int count = 1;
		int x = 0 , y = 0;
		for(int i = 1 ; i <= 25 ; i ++) {
			System.out.println(x+"번 줄 , "+y+"번 칸에 "+i+"를 대입");
			data[x][y] = i;
			y++;
			if(y >= 5) {//삐져나가면
				//다음줄로 이동 처리
				x++;
				y = 0;
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