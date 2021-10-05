package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test08 {
	public static void main(String[] args) throws Exception  {

		//입력
		String keyword = "zxc";

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");
	
		String sql = "select * from member where instr(member_id, ?) > 0 or instr(member_nick, ?) > 0";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setString(2, keyword);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.print(rs.getString("member_id"));
			System.out.print(" / ");
//			System.out.print(rs.getString("member_pw"));
//			System.out.print(" / ");
			System.out.print(rs.getString("member_nick"));
			System.out.print(" / ");
			System.out.print(rs.getDate("member_birth"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_email"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_phone"));
			System.out.print(" / ");
			System.out.print(rs.getDate("member_join"));
			System.out.print(" / ");
			System.out.print(rs.getString("member_point"));
			System.out.print(" / ");
			System.out.println(rs.getString("member_grade"));
		}

		con.close();
	}
}
