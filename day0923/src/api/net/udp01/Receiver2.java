package api.net.udp01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class Receiver2 {
	public static void main(String[] args) throws IOException {
		//UDP 수신 코드 작성 시 주의사항
		//= 사용자가 전송하는 양과 관계 없이 수신할 단위 크기를 지정해야 한다.

		//수신 도구 생성 - 포트를 반드시 지정해줘야 한다.
		DatagramSocket ds = new DatagramSocket(30000);

		//수신하기 위한 저장공간 생성
		//= 사용자가 얼마만큼의 데이터를 보낼지는 모르지만 크기를 미리 가정해서 생성

		byte[] data = new byte[80];//80 byte 저장소
		//DatagramPacket dp = new DatagramPacket(받을데이터공간, 받을크기);
		DatagramPacket dp = new DatagramPacket(data, data.length);
		System.out.println("수신 준비 완료");

		//수신
		ds.receive(dp);
		System.out.println("수신 완료");

		//확인
		System.out.println(Arrays.toString(data));//있는 그대로의 배열을 출력

		//수신한 데이터를 문자열로 복원(String 생성자 이용)
		int size = dp.getLength();
		System.out.println("size = " + size);

		//data의 내용 중 0번위치부터 size개만큼 String으로 변환
		String text = new String(data, 0, size);
		//String text = new String(dp.getData(), 0, dp.getLength());
		System.out.println("text = " + text);

		//정리
		ds.close();
		System.out.println("정리 완료");
	}
}
