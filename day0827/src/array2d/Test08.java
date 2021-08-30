package array2d;

import java.util.Random;

public class Test08 {

	public static void main(String[] args) {

		//입력
		int size = 5;
		int[][] map = new int[size][size];

		//처리
		//1. (0,0)부터 (4,4)까지 1~25 사이의 랜덤값을 대입 - 위치 기준
		//2. 1부터 25까지의 값을 순서대로 랜덤한 위치에 대입 - 값 기준
		Random r = new Random();
		for(int i=1; i <= size*size; i++) {
			int x = r.nextInt(size);//0부터 size개;
			int y = r.nextInt(size);//0부터 size개;
			//System.out.println(i+"값을 ("+x+", "+y+") 위치에 대입");

			//if(한번도 값을 넣은 적 없는 칸이라면) {
			if(map[x][y] == 0) {
				map[x][y] = i;
			}
			else {
				//위치를 다시 뽑아라(다음 회차로 진행하지 못하도록 반복변수 i를 제자리로 설정)
				i--;
			}
		}

		//출력
		for(int i=0; i < size; i++) {
			for(int k=0; k < size; k++) {
				System.out.print(map[i][k]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
}
