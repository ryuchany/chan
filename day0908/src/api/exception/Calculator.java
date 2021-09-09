package api.exception;

public class Calculator {

	// 나누기 기능
	// = 발생하는 예외를 처리하기가 매우 애매하다
	// = 처리를 하지 않고 미룬다(전가한다)
	// = 메소드 마지막에 throws 예외종류를 작성하여 "불완전한" 메소드임을 표시
	// = 프로그램 내에서발생하는 예외를 몽땅 모아서 처리할 수 있도록 만들어주는 기술
	public int div(int a, int b) throws Exception {
		return a / b;
	}
}
