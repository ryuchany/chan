package api.net.tcp04;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

		//서버에서 전송되는 데이터(로또번호 6개)를 수신하여 출력
		//= 멀티바이트 수신코드
		InputStream in = socket.getInputStream();
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);

		for(int i=0; i < 6; i++) {
			int number = data.readInt();
			System.out.println("로또번호 : "+number);
		}

		socket.close();
	}
}
