package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//menu 테이블을 조회하는 프로그램

		//입력 없음

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from menu";
		PreparedStatement ps = con.prepareStatement(sql);
		//실행 시킨 뒤 발생하는 결과집합(ResultSet)을 반환하라!
		//= 결과집합은 데이터가 복사되어 저장된 형태가 아니라 영상통화처럼 참조만 가능한 형태이다
		//= 따라서 연결이 끊어지면 사용이 불가능하다
		ResultSet rs = ps.executeQuery();

		con.close();

		//출력
		System.out.println("조회 완료");
	}
}
