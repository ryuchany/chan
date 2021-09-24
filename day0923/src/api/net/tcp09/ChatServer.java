package api.net.tcp09;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(30000);

		Socket socket = server.accept();

		//(수신) 클라이언트에서 보내는 메세지를 수신 - main
		//(발신) 클라이언트로 메세지를 전송 - thread

		//스레드 생성 및 구동 코드
		Runnable r = ()->{
			//발신 작업(무한반복) - /exit라고 입력하면 중지
		};
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();

		//수신 작업(무한반복) - /exit라는 메세지가 수신되면 중지

		socket.close();

		server.close();

	}
}
