package api.net.tcp01;

import java.io.IOException;
import java.net.ServerSocket;

//TCP 서버에서 필요한 코드를 분석
//= 음식점과 같은 가게의 역할과 비슷하다.
//= 가게 문을 열고 손님을 받을 준비를 해야 한다.
//= 가게 문을 연다는 것은 프로그램을 구동시킨다는 것을 의미
//= 프로그램은 구동되려면 반드시 포트를 설정해야 한다.
//= 포트의 범위는 0 부터 65535 까지이다.
//= (중요) 하나의 포트에는 하나의 프로그램만 구동할 수 있다.
public class Server {
	public static void main(String[] args) {

//		ServerSocket server = new ServerSocket(포트번호);
		try {
			ServerSocket server = new ServerSocket(30000);
			System.out.println("사용 가능한 번호입니다");
		} catch (IOException e) {
			System.out.println("이미 사용중인 번호입니다");
		}

	}
}
