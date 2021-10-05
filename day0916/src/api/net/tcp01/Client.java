package api.net.tcp01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//TCP 클라이언트에서 필요한코드
//=클라이언트는 음식점에 비유하면 손님과 같은 역할을 수행
//=손님은 가게가 문을 열면 전화를 걸어서 음식을 주문할 수 있다.
//= 전화를 거는 행위는 소켓을 생성한다고 볼 수 있다.
//= 전화를 걸기 위해서는전화번호가 필요한 것처럼 소켓을 생성하려면 대상 프로그램의 위치정보가 필요하다
//= IPv4정보와 Port정보가 필요하다.
public class Client {
	public static void main(String[] args) {

//		Socket Socket = new Socket(IP주소, Port번호);
		try {
			Socket socket = new Socket("1.220.236.75", 30000);// 127.0.0.1은 IP계의 this
			// Plan A : 정상적으로 연결이 수행된 경우
			System.out.println("연결 성공했습니다");
		} catch (Exception e) {
			// Plan B : 어떠한 원인에 의해 연결이 수행되지 않은 경우
			System.out.println("연결이 실패했습니다");
			e.printStackTrace();
		}

	}
}
