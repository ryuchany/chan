package api.net.udp03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

//멀티캐스트(Multicast)
//= 특정 채널에 가입하여 채널 단위의 메세지 전송을 하는 방식
//= 특정 채널에 대한 조건이 존재한다.
//= 멀티캐스트용 IP 중에서 원하는 것을 골라서 만든다.
//= 범위 : (224.0.0.0 ~ 239.255.255.255)
public class MulticastSender {
	public static void main(String[] args) throws IOException {
		// 채널 정보 설정
		String channel = "224.0.0.0";
		int port = 30000;

		// 주소 객체 생성(분석 및 오류 검사)
		InetAddress address = InetAddress.getByName(channel);

		// Multicast에서는 Unicast와 다른 클래스를 사용한다
		// = MulticastSocket

		// DatagramSocket ds = new DatagramSocket();//Unicast
		MulticastSocket ms = new MulticastSocket();// Multicast
		System.out.println("멀티캐스트 도구 생성");

		// 채널 참여
		ms.joinGroup(address);
		System.out.println("채널 참여 : " + address);

		// 데이터 준비 및 전송
		String text = "Hello Multicast!";
		byte[] data = text.getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, address, port);

		ms.send(dp);
		System.out.println("채널 메세지 전송 완료");

		// 정리
		ms.close();
		System.out.println("사용 종료");
	}
}
