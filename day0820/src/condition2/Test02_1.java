package condition2;
import java.lang.*;
public class Test02_1 {
	public static void main(String[] args) {
		//switch의 특징
		//= break 키워드 사용 가능(안쓰면 끝날 때까지 실행)
		//= case의 순서는 마음대로 조정 가능

		//입력
		int month = 7;

		//처리
		//출력
		switch(month) {//month의 값에 따라 특정 지점으로 이동시키도록 하겠다!
		case 1: case 3:	case 5:	case 7:	case 8:	case 10: case 12:
			System.out.println(31);
			break;
		case 2://month == 2인 경우 이동할 지점(책갈피)
			System.out.println(28);
			break;
		case 4:	case 6:	case 9:	case 11:
			System.out.println(30);
			break;
		}
	}
}
