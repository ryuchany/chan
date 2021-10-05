package api.net.tcp02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(30000);
		Socket socket = server.accept();

		// Client에게 byte 5개를 전달하는 코드
		// = socket.getOutputStream()을 활용하여 출력
		OutputStream out = socket.getOutputStream();

		out.write(104);
		out.write(101);
		out.write(108);
		out.write(108);
		out.write(111);

		socket.close();
		server.close();
	}
}
