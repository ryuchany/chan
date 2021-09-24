package api.net.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MessageSender {
	public static void main(String[] args) throws IOException {

		// 필요한 도구 준비
		Scanner sc = new Scanner(System.in);// 표준 입력(키보드) 도구
		DatagramSocket ds = new DatagramSocket();// UDP 전송 도구

		// 사용자 입력
		System.out.print("입력 : ");
		String line = sc.nextLine();

		// 바이트 변환
		byte[] data = line.getBytes(/* 인코딩방식 */);

		// 전송을 위한 그릇(DatagramPacket) 준비
		InetAddress address = InetAddress.getByName("localhost");// 주소 검사 및 분석 객체
		DatagramPacket dp = new DatagramPacket(data, data.length, address, 23456);

		// 전송
		ds.send(dp);

		// 정리
		ds.close();
		sc.close();
	}
}
