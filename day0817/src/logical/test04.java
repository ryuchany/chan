package logical;
import java.lang.*;
public class test04 {

	public static void main(String[] args) {
		// 과속단속 카메라는 제한속도에서 10%의 여유치를 가지고 작동합니다.
		// 제한속도가 100km인 도로에 설치된 과속단속 카메라가 있을 때
		// 109km로 달리고 있는 자동차가 과속인지 아닌지 판정하여 출력하세요
		
		//입력
		int speed = 109;
		int limit = 100;
		int permit = 10; //여유치(%)
		
		//처리
		int fixLimit = limit * (100+permit) / 100; // 여유치합산
		boolean over = speed > fixLimit;
		
		//출력
		System.out.println(fixLimit);
		System.out.println(over);
				
	}
}
