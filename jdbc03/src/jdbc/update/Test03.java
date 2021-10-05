package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 준비
		String memberId = "testuser2";// 회원ID
		String memberPw = "testuser2";// 기존PW
		String newPw = "testuser1234";// 변경할PW

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

//		String sql = "update member "
//							+ "set member_pw = ? "
//							+ "where member_id = ? and member_pw = ?";
		String sql = "UPDATE MEMBER " + "SET MEMBER_PW = ? " + "WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPw);
		ps.setString(2, memberId);
		ps.setString(3, memberPw);
		int count = ps.executeUpdate();

		con.close();

		// 결과
		if (count > 0) {
			System.out.println("비밀번호 변경이 완료되었습니다");
		} else {
			System.out.println("비밀번호 변경에 필요한 정보가 잘못되었습니다");
		}
	}
}
