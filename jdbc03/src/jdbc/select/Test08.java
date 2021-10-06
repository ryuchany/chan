package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test08 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		select * from member where member_id like '%'||?||'%' or member_nick like '%'||?||'%';
//		select * from member where instr(member_id, ?) > 0 or instr(member_nick, ?) > 0;

//		입력
		String keyword = "2";

//		처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

//		String sql = "select * from member where member_id like '%'||?||'%' or member_nick like '%'||?||'%';";
		String sql = "select * from member where instr(member_id, ?) > 0 or instr(member_nick, ?) > 0";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setString(2, keyword);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("member_id"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_nick"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_grade"));
			System.out.println();
		}

		con.close();

	}
}
