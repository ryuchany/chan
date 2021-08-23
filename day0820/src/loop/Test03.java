package loop;
import java.lang.*;
public class Test03 {
	public static void main(String[] args) {
//10부터 0까지 카운트다운 출력을 수행하는 프로그램을 구현해보세요
		//10 부터 0까지 1씩 감소
		//= 선언부 : int i = 10
		//= 조건부 : i >= 0
		//= 증감부 : i -= 1, i--, --i
		
		for(int i = 10; i >= 0;  i-- ) {
			System.out.println(i);
		}
	}
}
