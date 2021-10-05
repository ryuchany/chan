package input;
import java.io.IOException;
import java.lang.*;
public class test01 {
	public static void main(String[] args) throws IOException {
		
		//System.in.read() 예제
		//앞으로 사용하지 않지만 알아야하는 입력의 기초 개념
		//= System.in의 명령을 이용하여 입력을 받는다.
		//= 입력 통로와의 연결이 이루어지지 않았을 경우에는 오류(예외)가 발생
		//= ascii 코드 한 개를 읽어온다(unincode가 아님)
		//= 다양한 입력을 처리하기가 매우 어렵다
		//= 다른 추가 도구들을 사용하여 위의 문제점들을 해결한 방식으로 입력받는다
		//= Scanner, BufferedInputStream, ...
		
		int a = System.in.read();
		System.out.println("a = " + a);
		
		
	}
}
