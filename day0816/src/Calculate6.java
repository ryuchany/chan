import java.lang.*;
public class Calculate6 {
	public static void main(String[] args) {
		//Q. 우리 가족은 성인 2명, 청소년 2명, 어린이 1명으로 구성되어 있습니다.
		//지하철 요금이 다음과 같을때 우리 가족이 지하철을 타기 위해 내야할 금액을 출력
		//성인, 청소년, 어린이, 총 금액을 출력
		//<요금표> 성인 : 1250원, 청소년 : 720원, 어린이 : 450원
		
		
		//입력
		int adultPrice = 1250, adultCount = 2; 
		int teenPrice = 720, teenCount = 2; 
		int childPrice = 450, childCount = 1; 
		
		//처리
		int adultTotal = adultPrice*adultCount;
		int teenTotal = teenPrice*teenCount;
		int childTotal = childPrice*childCount;
		int total = adultTotal + teenTotal + childTotal;
		
		//출력
		System.out.println(adultTotal);
		System.out.println(teenTotal);
		System.out.println(childTotal);
		System.out.println(total);
	}
}
