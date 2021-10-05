package api.net.tcp07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//목표 : 에코 서버(Echo server). 사용자가 보낸 메세지를 그대로 반환하는 서버
public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(30000);

		Socket socket = server.accept();

//		수신(입력)과 발신(출력)을 위한 스트림을 모두 준비해야 한다.
//		= 수신후 바로 전송이 가능

//		수신용 스트림
		InputStream in = socket.getInputStream();
		InputStreamReader inConverter = new InputStreamReader(in);
		BufferedReader inBuffer = new BufferedReader(inConverter);

//		발신용 스트림
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter outConverter = new OutputStreamWriter(out);
		BufferedWriter outBuffer = new BufferedWriter(outConverter);
		PrintWriter printer = new PrintWriter(outBuffer);

//		메세지 수신 후 바로 발신
		String line = inBuffer.readLine();
		printer.println(line);
		printer.flush();

		socket.close();

		server.close();

	}
}
