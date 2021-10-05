package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//준비
		String memberId = "testuser1";
		String memberPw = "testuser1";

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "delete member where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);

		int count = ps.executeUpdate();

		con.close();

		//결과
		System.out.println("count = " + count);
		if(count > 0) {
			System.out.println("회원 탈퇴가 완료되었습니다");
		}
		else {
			System.out.println("정보가 일치하지 않습니다");
		}
	}
}
