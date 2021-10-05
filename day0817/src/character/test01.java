package character;
import java.lang.*;
public class test01 {
	public static void main(String[] args) {
		// Q : 자바에서 글자는 어떻게 취급되는가? 
		// A : 자바는 1글자에 2byte 형태로 관리합니다.
		// = 글자마다 숫자가 할당되어 있으며, 원한다면 언제든지 확인할 수 있습니다.
		
		char a = '가';
		System.out.println(a);
		
		char b = 44032;
		System.out.println(b);
		System.out.println((int)b);
		
		int c = a;
		System.out.println(c);
		
		// ' 처럼 기호와 겹쳐서 사용이 어려운 글자들은 앞에 \를 추가하여 글자임을 명시
		// = Escape sequence = 이스케이프 문자
		char d = '\'';
		System.out.println(d);
		
	}
}
