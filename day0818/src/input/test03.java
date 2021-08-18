package input;
import java.lang.*;
import java.util.Scanner;
public class test03 {
	public static void main(String[] args) {
		//사용자에게 다음의 정보를 입력받아 요구사항에 맞게 계산 후 출력
		// 입력받을 정보 
		// -이름, -국어점수, -영점수
		//출력할 정보
		// - 이름, -총점, -평균
		
		//입력
		
		// 도구 생성
		Scanner sc = new Scanner(System.in);
		// 도구 사용
		System.out.println("이름을 입력하세요");
		String name = sc.next(); // 이름
		
		System.out.println("국어점수를 입력하세요");
		int  korean = sc.nextInt(); // 국어점수
		
		System.out.println("영어점수를 입력하세요");
		int  english = sc.nextInt(); // 영어점수
		// 도구 종료
		sc.close();
		
		//처리
		double number = 2; // 과목수		
		int sum = korean+english; // 총점
		double avg = (korean+english)/number; //평균
		
		//결과
		System.out.println("이름 = " + name);
		System.out.println("총점 = " + sum + "점");
		System.out.println("평균 = " + avg + "점");
	
	}
}
