package api.net.tcp05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(30000);

		Socket socket = server.accept();

		//수신 or 발신 코드

		//데이터 준비
		String str = "어서와 Java는 처음이지";

		//출력스트림 준비
		//= socket에는 outputstream/inputstream밖에 없다
		//= writer/reader 계열을 사용하고 싶다면 "변환"이 필요
		//= 이 역할을 수행하는 클래스가 OutputStreamWriter/InputStreamReader
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter converter = new OutputStreamWriter(out);
		BufferedWriter buffer = new BufferedWriter(converter);
		PrintWriter printer = new PrintWriter(buffer);

		printer.println(str);
		printer.flush();
		System.out.println("전송 완료");

		socket.close();

		server.close();

	}
}
