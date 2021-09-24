package api.net.udp02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MessageSender4 {
	public static void main(String[] args) {

		//필요한 도구 준비
		try(
			Scanner sc = new Scanner(System.in);//표준 입력(키보드) 도구
			DatagramSocket ds = new DatagramSocket();//UDP 전송 도구
		){
			while(true) {
				//사용자 입력
				System.out.print("입력 : ");
				String line = sc.nextLine();

				//바이트 변환
				byte[] data = line.getBytes(/* 인코딩방식 */);

				//100byte가 넘는지 검사
				final int LIMIT = 100;
				if(data.length > LIMIT) {
					System.out.println("100byte를 초과하는 데이터는 전송할 수 없습니다.");
					continue;//재입력을 원할 경우
					//break;//반복 종료를 원할 경우
					//return;//main 종료를 원할 경우
					//System.exit(-1);//프로그램 종료를 원할 경우

					//throw new RuntimeException();//RuntimeException은 "실행중 발생한"이라는 의미의 예외
				}

				//비어있는 문자열 검사
				//if(line.equals("")) {
				//if(line.length() == 0) {
				//if(line.isEmpty()) {
				if(data.length == 0) {
					System.out.println("비어있는 문자열은 전송할 수 없습니다");
					continue;
				}

				//전송을 위한 그릇(DatagramPacket) 준비
				InetAddress address = InetAddress.getByName("localhost");//주소 검사 및 분석 객체
				DatagramPacket dp = new DatagramPacket(data, data.length, address, 30000);

				//전송
				ds.send(dp); 
				System.out.println("전송 완료");
			}
		}
		catch(Exception e) {
			e.printStackTrace();//예외 추적 결과 출력
		}

	}
}
