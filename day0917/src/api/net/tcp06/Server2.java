package api.net.tcp06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(30000); Socket socket = server.accept();) {
			// 사용자가 지속적으로 보내는 문자열 데이터를 받아서 출력하는 코드
			InputStream in = socket.getInputStream();
			InputStreamReader converter = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(converter);

			while (true) {
				String line = buffer.readLine();
				System.out.println("수신 : " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
