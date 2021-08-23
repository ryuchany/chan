package condition2;
import java.lang.*;
public class Test02_3 {
	public static void main(String[] args) {
		//switch의 특징
		//= break 키워드 사용 가능(안쓰면 끝날 때까지 실행)
		//= case의 순서는 마음대로 조정 가능
		//= default는 case로 처리되지 않을 경우 실행(기본위치)

		//입력
		int month = 7;

		//처리
		int day;
		switch(month) {
		case 2: 
			day = 28; 
			break;
		case 4: case 6: case 9: case 11:
			day = 30; 
			break;
		default:
			day = 31;
			break;
		}

		//출력
		System.out.println(day);
	}
}
