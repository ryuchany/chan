package condition2;
import java.lang.*;
public class Test02 {
	public static void main(String[] arms){
		//switch의 특징
		// = break 키워드 사용 가능
		
		
		//입력
		int month = 11;
		
		//처리
		
		//출력
		switch(month) {//month의 값에 따라 특정 지점으로 이동시키도록 하겠다!
		case 1: // month == 1인 경우 이동할 지점(책갈피)
			System.out.println(31);
			break;
		case 2: // month == 2인 경우 이동할 지점(책갈피)
			System.out.println(28);
			break;
		case 3:
			System.out.println(31);
			break;
		case 4:
			System.out.println(30);
			break;
		case 5:
			System.out.println(31);
			break;
		case 6:
			System.out.println(30);
			break;
		case 7:
			System.out.println(31);
			break;
		case 8:
			System.out.println(31);
			break;
		case 9:
			System.out.println(30);
			break;
		case 10:
			System.out.println(31);
			break;
		case 11:
			System.out.println(30);
			break;
		case 12:
			System.out.println(31);
			break;
		}
		
		
	}
}
