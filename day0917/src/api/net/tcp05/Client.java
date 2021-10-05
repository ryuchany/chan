package api.net.tcp05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

//		수신 or 발신 코드

//		수신을 위한 스트림 구성
//		InputStream in = socket.getInputStream();
//		InputStreamReader converter = new InputStreamReader(in);
//		BufferedReader buffer = new BufferedReader(converter);

//		InputStreamReader converter = new InputStreamReader(socket.getInputStream());
//		BufferedReader buffer = new BufferedReader(converter);

		BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String str = buffer.readLine();
		System.out.println("str = " + str);

		socket.close();
	}
}
