package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 준비
		String memberId = "testuser3";// 확인용ID
		String memberPw = "testuser3";// 확인용PW
		String memberNick = "임시3";// 변경할nickname
		String memberBirth = "2000-10-10";// 변경할 생년월일
		String memberEmail = "test3@kh.com";// 변경할 이메일
		String memberPhone = "010-1010-2020";// 변경할 전화번호

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "update member " + "set " + "member_nick=? , " + "member_birth = to_date(?, 'YYYY-MM-DD'), "
				+ "member_email = ?, " + "member_phone = ? " + "where " + "member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberNick);
		ps.setString(2, memberBirth);
		ps.setString(3, memberEmail);
		ps.setString(4, memberPhone);
		ps.setString(5, memberId);
		ps.setString(6, memberPw);
		int row = ps.executeUpdate();

		con.close();

		// 결과
		if (row > 0) {
			System.out.println("정보가 성공적으로 변경되었습니다");
		} else {
			System.out.println("정보 변경에 실패했습니다. 인증 정보가 일치하지 않습니다");
		}
	}
}
