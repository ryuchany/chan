package array;

public class Test12 {

	public static void main(String[] args) {
		//배열의 위치를 이용하여 할 수 있는 작업
		//배열에서는 위치를 이용하여 데이터들을 서로 바꾸거나 이동할 수 있다
		
		//입력
		int[] data = new int[] {30, 50, 20, 10, 40};
		System.out.println(data.length);
		
		//처리
		int temp = data[3];
		data[3] = data[2] ;
		data[2] = data[1] ;
		data[1] = temp;
 		
		//출력
		for(int i=0; i <data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
