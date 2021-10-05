package logical;
import java.lang.*;
public class test05 {

	public static void main(String[] args) {
		//같다, 다르다
		
		int n = 12345;
		
		//잘못된 식 : n에 12345 넣고 출력하세요(사용하지 않는 형태의 식)
		//System.out.println(n = 12345);
		
		//올바른 식 : n의 값이 12345와 같습니까?
		System.out.println(n == 12345);
		
		//올바른 식 : n의 값이 12121이 아닙니까?
		System.out.println(n != 12121);
		
		//활용 : n이 짝수 입니까?
		// = n을 2로 나눈 나머지가 0과 같습니까?
		//System.out.println(n % 2 == 0 );
		boolean even = n % 2 == 0;
		System.out.println(even);
		
	}
}
