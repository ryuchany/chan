package api.net.tcp07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

//		수신용 스트림
		InputStream in = socket.getInputStream();
		InputStreamReader inConverter = new InputStreamReader(in);
		BufferedReader inBuffer = new BufferedReader(inConverter);

//		발신용 스트림
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter outConverter = new OutputStreamWriter(out);
		BufferedWriter outBuffer = new BufferedWriter(outConverter);
		PrintWriter printer = new PrintWriter(outBuffer);

		String text = "Hello Java!";
		printer.println(text);
		printer.flush();

		String line = inBuffer.readLine();
		System.out.println("회신 : " + line);

		socket.close();
	}
}
