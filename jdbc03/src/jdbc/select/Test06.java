package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//select * from menu where menu_price between 5000 and 8000;

		//입력
		int min = 5000;
		int max = 8000;

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from menu "
							+ "where menu_price between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.print(rs.getString("menu_name"));
			System.out.print(" / ");
			System.out.print(rs.getInt("menu_price"));
			System.out.print(" / ");
			System.out.println(rs.getString("menu_type"));
		}

		con.close();
	}
}
