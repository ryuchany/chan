package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//입력
		String memberId = "asdasd111";
		String memberPw = "asdasd111";
		String memberNick = "학생1236";
		String memberBirth = "1990-05-25";
		String memberEmail = "asd1234@aa.com";
		String memberPhone = "010-1231-3453";

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		//#1. 형식을 지정할 경우
		String sql1 = "insert into member("
									+ "member_id, "
									+ "member_pw, "
									+ "member_nick, "
									+ "member_birth, "
									+ "member_email, "
									+ "member_phone"
							+ ") values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?)";

		//#2. 형식을 지정하지 않을 경우
		String sql2 = "insert into member values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 100, '준회원')";

		PreparedStatement ps = con.prepareStatement(sql2);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		ps.setString(3, memberNick);
		ps.setString(4, memberBirth);
		ps.setString(5, memberEmail);
		ps.setString(6, memberPhone);
		ps.execute();

		con.close();

		//출력
		System.out.println("회원 가입이 완료되었습니다");
	}
}
