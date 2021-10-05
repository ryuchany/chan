package api.net.tcp10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class MultiSocketServer3 {

	public static void main(String[] args) throws IOException {

		try (ServerSocket server = new ServerSocket(30000);) {
			while (true) {
				Socket socket = server.accept();

				TcpUser u = new TcpUser(socket);
				TcpUser.enter(u);// 입장 메소드 호출
			}
		} catch (Exception e) {
			// e.printStackTrace();
			// 연결 제거
		}
	}

}
