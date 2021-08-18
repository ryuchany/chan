package condition;
import java.lang.*;
import java.util.Scanner; 
public class test05 {
	public static void main(String[] args) {

		//다음 요구사항에 맞게 성적관리 프로그램을 구현하세요
		// 입력 
		// 사용자 이름, 국어점수, 영어점수, 수학점수
		// 처리
		// 총점, 평균, 통과인지 판정(각 과목 40점 이상이고 평균 60점 이상)
		// 출력
		// 이름, 총점, 평균
		// 통과인지 아닌지 결과를 문자열로 출력(해당 평가 통과입니다/재평가입니다)
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("국어점수를 입력하세요");
		int korean = sc.nextInt();
		System.out.println("영어점수를 입력하세요");
		int english = sc.nextInt();
		System.out.println("수학점수를 입력하세요");
		int match = sc.nextInt();
		sc.close();
		
		//처리
		double sum = (double) korean + english + match ;
		double avg = (sum/3);
		
		boolean pass = 60 <= avg && 40 <= korean && 40 <= english && 40 <= match ;
	
		//결과
		if(pass) {
			System.out.println("이름 = " + name);
			System.out.println("총점 = " + sum + "점");
			System.out.println("평균 = " + avg + "점");
			System.out.println("해당 평가 통과 입니다!");
			
		}
		else {
			System.out.println("이름 = " + name);
			System.out.println("총점 = " + sum + "점");
			System.out.println("평균 = " + avg + "점");	
			System.out.println("재평가 입니다!");
		}
		
		
	}
}
