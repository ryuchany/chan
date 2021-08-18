package input;
import java.lang.*;
import java.util.Scanner;
public class test04 {
	public static void main(String[] args) {
		//과거에 만들었던 BMi 계산기에 입력 기능을 더해서 다음 요구사항에 맞게 구현
		
		//참고 : double은 sc.nextDouble()이라는 명령으로 입력 가능
		//입력 : 이름, 신장(cm), 체중(kg)
		//처리 : BMI 수치 , 과체중인지 판정( BMI가 24.5 이상 이면 과체중)
		//출력 : 계산된 BMI 수치, 과체정 여부(true/false)
		
		
		//입력
		// 도구 생성
		Scanner sc = new Scanner(System.in);
		// 도구 사용
		System.out.println("이름을 입력하세요");
		String name = sc.next(); // 이름
		System.out.println("신장(cm) 입력하세요");
		double cm = sc.nextDouble(); // 신장
		System.out.println("체중(kg) 입력하세요");
		double kg= sc.nextDouble(); // 체중
		// 도구 종료
		sc.close();
		
		//처리 
		double m = (double) cm /100; // 체중 m단위로 변경
		double bmi = kg / (m * m); // bmi 계산
		boolean bmiOver = bmi >= 24.5 ; // 과체정 여부
		
		//결과
		System.out.println("이름 = " + name);
		System.out.println("BMI 수치 = " + bmi );
		System.out.println("과체중 여부 = " + bmiOver);
	
	}
}
