package array;

public class Test17 {
	public static void main(String[] args) {
		// 삽입 정렬 (Insertion Sort)
		// 좌측부터 순서대로 백업 후 들어갈 위치를 만든 뒤 삽입하는 방식의 정렬

		//입력
		int[] data = new int[] {30, 50, 20, 10, 40, 25, 35, 15, 5, 45, 90};

		//출력
		System.out.print("[");
		for(int i=0; i < data.length; i++) {
			System.out.print(data[i]);
			if(i < data.length - 1) {//마지막 데이터가 아니라면
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();

		//처리 : 삽입정렬
		//for(int k=0; k < 5; k++) {
		for(int k=0; k < data.length; k++) {
			int backup = data[k];//백업 데이터
			int location = k;//삽입 위치

			for(int i=k-1; i >= 0; i--) {
				if(backup < data[i]) {//backup보다 data[i]가 더 크다면
					data[i+1] = data[i];//데이터(data[i])를 우측으로 1칸 이동
					location--;//위치(location) 1 감소
				}
			}
			data[location] = backup;//백업 데이터를 목적지(location) 위치에 삽입
		}



		//출력
		System.out.print("[");
		for(int i=0; i < data.length; i++) {
			System.out.print(data[i]);
			if(i < data.length - 1) {//마지막 데이터가 아니라면
				System.out.print(" , ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
}
