package array;

public class Test07 {

	public static void main(String[] args) {
		// 배열의 생성 방법과 유용한 보조 기능

		// ex : 10, 20, 30을 배열에 저장

		// 1) 칸 수를 지정하여 생성
		//int size = 3;
		//int[] a = new int[size];
		int[] a = new int[3];

		a[0] = 10;
		a[1] = 20;
		a[2] = 30;

		//for (int i = 0; i < size; i++) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("a = " + a[i]);
		}

		// 2) 생성과 동시에 데이터 초기화
		// = 데이터 개수를 작성하면 Error!
		int[] b = new int[] { 10, 20, 30 };//(b) -----> [ 10 ] [ 20 ] [ 30 ]
		System.out.println("length = " + b.length);//배열 생성 시 배열의 크기를 저장하기 위한 장소

		for(int i = 0 ; i < b.length ; i ++) {
			System.out.println("b = " + b[i]);
		}
	}
}
