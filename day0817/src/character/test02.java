package character;
import java.lang.*;
public class test02 {
	public static void main(String[] args) {
		// 문자열 (String)
		// = 문자가 줄지어 있는 형태의 데이터
		// = 프로그래밍에서 가장 중요한 데이터 중 하나
		// = 쌍따옴표로 감싸서 표기
		
		String a = "hello";
		System.out.println(a);
		
		//참조형 데이터 (Reference Type)
		// = 복잡한 데이터(객체)에 리모컨(참조변수)을 연결해놓은 형태
		// = 리모컨(참조변수)을 이용하여 다양한 버튼(기능)을 실행할 수 있다.
		System.out.println(a.length()); //a의 글자수
		System.out.println(a.charAt(0)); //a의 +0지점 위치의 글자
		
	}
}
