package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test07_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//select * from product where name like '%바%';
		//select * from product where instr(name, '바') > 0;
		//select * from product where regexp_like(name, '바');

		//입력
		String keyword = "바";

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from product where regexp_like(name, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.print(rs.getInt("no"));
			System.out.print(" / ");
			System.out.print(rs.getString("name"));
			System.out.print(" / ");
			System.out.print(rs.getString("type"));
			System.out.print(" / ");
			System.out.print(rs.getInt("price"));
			System.out.print(" / ");
			System.out.print(rs.getDate("made"));
			System.out.print(" / ");
			System.out.print(rs.getDate("expire"));
			System.out.println();
		}

		con.close();
	}
}
