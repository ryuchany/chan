package jdbc.select2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.JdbcUtils;

public class Test03 {
	public static void main(String[] args) throws Exception {

		String member_id = "zxczxc";

		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {// 있으면
			System.out.print(rs.getString("member_id"));
			System.out.print(" / ");
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
			System.out.print(rs.getInt("member_point"));
			System.out.print(" / ");
			System.out.println(rs.getString("member_grade"));
		} else {// 없으면
			System.out.println("찾으시는 아이디의 회원이 없습니다");
		}

		con.close();

	}
}
