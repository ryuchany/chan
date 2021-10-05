package loop;
import java.lang.*;
public class Test01 {
	public static void main(String[] args) {
		//Q : Hello World를 5번 출력
		//= i를 손바닥에 있는 종이의 개수라고 생각하고
		//= 최초 1개일때부터 5개가 될때까지 1개씩 늘려가면서 특정 작업을 실행하도록 구성
		//= 5번의 효과를 가진다
		//= for 반복문
		for(int i = 1 ; i <= 5; i = i +1) {
			System.out.println("Hello World");
		}
	}
}

//for의 형태
//for(선언문; 조건부; 증감부){
// 코드
//}
//실행순서 : 선언부->조건부->코드->증감부->코드->증감부->...