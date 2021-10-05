package api.net.tcp02;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {

//		Socket socket= new Socket("127.0.0.1", 30000);
		Socket socket = new Socket("localhost", 30000);

		// Server에서 전송되는 byte 5개를 수신하는 코드
		// = socket.getInputStream()을 활용하여 입력

		InputStream in = socket.getInputStream();

		int a = in.read();
		int b = in.read();
		int c = in.read();
		int d = in.read();
		int e = in.read();

		socket.close();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

	}
}
