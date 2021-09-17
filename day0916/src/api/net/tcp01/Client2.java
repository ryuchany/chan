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
public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {

			Socket socket = new Socket("1.220.236.75", 30000);
			System.out.println("연결 성공했습니다");
			
			System.out.println("소켓 정보 : "+socket);
			
			//데이터를 주고받는 코드
			
			
			//연결 종료
			socket.close();
			System.out.println("서버와의 연결이 종료되었습니다");

		}
}
