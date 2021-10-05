package api.net.udp01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender2 {
	public static void main(String[] args) throws IOException {
		//UDP 통신
		//= 비연결형 프로토콜(통신방식)
		//= 서버와 클라이언트의 개념이 없다.
		//= 보내는 주체(Sender)와 받는 주체(Receiver)만이 존재한다.
		//= 크기 제한이 존재한다(크기는 정하기 나름).

		//사용되는 클래스 : DatagramSocket, DatagramPacket

		//보내는 쪽에서는 전송을 위한 도구와 데이터를 준비
		DatagramSocket ds = new DatagramSocket();

		//데이터를 준비해서 ds를 이용하여 전송
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";//124byte

		//준비한 데이터를 byte로 변환
		byte[] data = text.getBytes();

		//DatagramPacket dp = new DatagramPacket(보내는데이터, 보내는크기, 주소객체, 포트번호);
		//DatagramPacket dp = new DatagramPacket(data, data.length, "localhost", 30000);//error

		InetAddress address = InetAddress.getByName("localhost");//127.0.0.1
		System.out.println(address);
		DatagramPacket dp = new DatagramPacket(data, data.length, address, 30000);

		//전송 코드
		ds.send(dp);
		System.out.println("전송 완료");

		//정리 코드
		ds.close();
		System.out.println("사용 종료");
	}
}
