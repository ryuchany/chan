package loop4;

public class Test02 {
	public static void main(String[] args) {
		//반복문을 중첩해야 하는 경우
		// 5번씩 3번
		//가장 안쪽(작은 반복)부터 구현하는 것이 좋습니다
		
		for(int i = 0; i<3; i++) { //3번짜리 반복(i)
			for(int j = 0; j<5; j++) { //5번짜리 반복(j)
				System.out.println("Hello Wolrd!");
			}
		}
	}
}
