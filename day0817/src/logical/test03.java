package logical;
import java.lang.*;
public class test03 {

	public static void main(String[] args) {
		//2005년생의 나이를 계산하여 출력하고, 성인인지 판정하여 출력
		//성인은 20살 이상인 사람을 의미합니다
		
		//입력
		int birth = 2005;
		
		//처리
		int thisyear = 2021;
		int age = thisyear-birth+1;
		boolean adult = age >= 20 ;
		
		//출력
		System.out.println(age);
		System.out.println(adult);

	}
}
