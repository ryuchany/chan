package condition;
import java.lang.*; 
public class test04 {
	public static void main(String[] args) {
		//(ex) 지하철 무임승차 대상인가?
		//= 65세 이상 어르신은 무임승차 대상
		//= 7세 이하 영유아는 무임승차 대상
		//= 7세 이하이면서 65세 이상일 수 있는가?
		//= 7세 이하 또는(||) 65세 이상
		
		
		//입력
		int age = 100;
		
		//처리
		boolean isFree = 7 >= age || age >= 65 ;
		System.out.println("무임승차? " + isFree);
		
	}
}
