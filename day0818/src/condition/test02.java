package condition;
import java.lang.*;
import java.util.Scanner;
public class test02 {
	public static void main(String[] args) {
	
		//다음 요구사항에 맞게 프로그램을 구현하세요.

		//- 입력 
		//	- 여행 갈 예정인 달을 1 ~ 12 사이의 값으로 입력받는다
			//- 여행 갈 기간을 일단위로 입력받는다
		
		//- 처리
			//- 여행 갈 예정인 계절이 여름인지 아닌지 판정한다(여름은 6, 7, 8월로 한다)
			//- 하루당 경비는 여름일 때와 아닐 때가 다르게 계산된다
				//- 여름일 경우 하루에 8만원
				//- 여름이 아닐 경우 하루에 10만원
		
		//- 출력
			//- 여름일 경우 "여름 특가 적용" 메세지와 함께 할인된 예상 경비를 출력한다.
			//- 여름이 아닐 경우 할인이 되지 않은 경비를 출력한다.
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("여행 시작 예정 월을 입력하세요");
		int month = sc.nextInt();
		System.out.println("여행을 기간을 일단위로 입력하세요");
		int days = sc.nextInt();
		sc.close();
		
		int salePrice = 80000;
		int originPrice = 100000;
		
		//처리
		boolean isSummer = month / 3 == 2;
		
		//출력
		if(isSummer) {
			int total = days * salePrice;
			System.out.println("여름 특가 할인이 적용됩니다!");
			System.out.println("할인된 금액 : " + total+ "원");
			 
		}
		else {
			int total = days * originPrice;
			System.out.println("예상 금액 : " + total +"원");
		}

	}
}
