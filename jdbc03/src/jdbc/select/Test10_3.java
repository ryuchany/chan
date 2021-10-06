package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test10_3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 입력
		String kind = "member_grade";
		String keyword = "준회원";

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", kind);
		// System.out.println(sql);

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("member_id"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_nick"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_email"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_phone"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_grade"));
			System.out.print("\n");
		}

		con.close();
	}
}
