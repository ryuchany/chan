package api.net.tcp04;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

		//서버에서 전송되는 데이터(로또번호 6개)를 수신하여 출력
		//= 서버에서 보내는 형태에 맞게 수신을 해야 한다.
		//		--> 서버에서 멀티바이트로 전송하면 멀티바이트 수신을 해야한다
		//		--> 서버에서 객체로 전송하면 객체 수신을 해야한다

		socket.close();
	}
}
