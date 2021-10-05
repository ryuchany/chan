package array2d;

public class Test06 {
	public static void main(String[] args) {
		// 입력(준비)
		int[][] data = new int[5][5];

		int count = 1;
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				// System.out.println("i = " + i + ", k = " + k);
				// System.out.println("k = " + k + ", i = " + i);

				// data[k][i] = count;
				// count++;

				// data[k][i] = ++count;//count를 1 증가 시킨 뒤 대입(증가를 제일 처음, 전위증가연산)
				data[k][i] = count++;// count를 대입한 뒤 1 증가 시킴(증가를 제일 마지막, 후위증가연산)
			}
		}

		// 출력
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
}