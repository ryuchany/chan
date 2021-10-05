package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//드라이버 설치 코드
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("오라클 드라이버 설치 완료!");

		//로그인 수행 - 연결(접속) 생성 - Connection 생성
		//= 필요한 정보 : 전송위치정보, 아이디, 비밀번호
		//Connection con = DriverManager.getConnection(위치정보, 아이디, 비밀번호);
		Connection con = DriverManager.getConnection(
										"jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");
		System.out.println("로그인 성공!");

		//명령 준비 및 전송 , 실행 및 결과 확인을 이곳에서 수행

		//접속 종료
		con.close();
	}
}
