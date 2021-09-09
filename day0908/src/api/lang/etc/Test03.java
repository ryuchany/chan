package api.lang.etc;

import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		// Runtime 클래스는 "실행 환경"을 이용할 수 있도록 제공되는 클래스
		// = 객체 생성 방식을 제한하여 원하는 형태로만 객체를 만들거나 이용하도록 제약
		// = 그래서 객체는 어떻게 만드는가?
		// = 객체 생성이 제한된 클래스는 반드시 객체 생성 메소드가 static으로 존재
		// = 일반적으로 가장 흔한 이름이 getInstance()이고, 그 외는 get + 클래스이름 으로 구성되는 경우가 많음

		// Runtime r = new Runtime();//불가능
		Runtime r = Runtime.getRuntime();// 생성이 아닌 생성 요청(만들어주세요~)

		// r.exec("notepad.exe");//메모장
		// r.exec("mspaint");//그림판
		// r.exec("calc");//계산기
		r.exec("cmd /c start http://www.naver.com");// 주소를 실행할 수 있는 최적의 방법 탐색
		// r.exec("cmd /c shutdown /f /p");//굿바이~
	}
}