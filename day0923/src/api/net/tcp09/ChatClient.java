package api.net.tcp09;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

		//(수신) 서버에서 보내는 메세지를 수신 후 출력 - thread
		//(발신) 사용자가 입력한 메세지를 서버로 전송 - main

		//스레드 생성 및 구동 코드
		Runnable r = ()->{
			//수신 코드
		};
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();

		//발신 코드

		socket.close();
	}
}
