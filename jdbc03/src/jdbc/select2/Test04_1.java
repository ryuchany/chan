package jdbc.select2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.JdbcUtils;

public class Test04_1 {
	public static void main(String[] args) throws Exception {
		// 입력
		String memberId = "testuser2";
		String memberPw = "testuser1234";

		// 처리
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "select * from member where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

		con.close();
	}
}
