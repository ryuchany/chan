package array2d;

public class Test07 {
	public static void main(String[] args) {
		// 배열 생성
		int[][] data = new int[5][5];

		int count = 1;
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				if (i % 2 == 0) { // 짝수 줄
//					System.out.println(i + " " + k);
					data[i][k] = count++;
				} else { // 홀수 줄
					int t = data[i].length - 1 - k;
					data[i][t] = count++;
//					System.out.println(i + " " + (data[i].length - 1 - k));
				}
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