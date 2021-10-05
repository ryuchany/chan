package api.net.udp03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//멀티캐스트 수신자
public class MulticastReceiver {
	public static void main(String[] args) throws IOException {
		//정보 생성
		String channel = "224.0.0.0";
		int port = 30000;
		InetAddress address = InetAddress.getByName(channel);

		//도구 생성
		//DatagramSocket ds = new DatagramSocket(port);//unicast
		MulticastSocket ms = new MulticastSocket(port);//multicast

		//채널 참여
		ms.joinGroup(address);

		//데이터 수신 준비 및 수신
		byte[] data = new byte[100];
		DatagramPacket dp = new DatagramPacket(data, data.length);

		ms.receive(dp);

		//복원 및 출력
		String text = new String(dp.getData(), 0, dp.getLength());
		System.out.println("text = " + text);

		//정리
		ms.close();
	}
}
