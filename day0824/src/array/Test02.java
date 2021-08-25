package array;

public class Test02 {

	public static void main(String[] args) {
		//변수 : 단일 데이터 저장소
		//배열 : 다중 데이터 저장소

		//= 배열은 변수만으로 처리하기 어려워서 나온 개념
		//= 어떤 상황에서 변수로 처리하는 것이 어려운지 파악하는 것이 중요!

		//10, 20, 30, 40, 50 이라는 숫자를 저장 및 합계계산 후 출력
		int[] arr = new int[5];//(arr) -----> [ 0 ][ 0 ][ 0 ][ 0 ] [ 0 ]
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		int total = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
		
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);
		System.out.println("arr[2] = " + arr[2]);
		System.out.println("arr[3] = " + arr[3]);
		System.out.println("arr[4] = " + arr[4]);
		
		System.out.println("total = " + total);
		
	}

}
