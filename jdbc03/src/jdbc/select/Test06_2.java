package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test06_2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//select * from menu where menu_price between 5000 and 8000;

		//입력
		int a = 8000;
		int b = 5000;

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from menu "
							+ "where menu_price between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, Math.min(a, b));
		ps.setInt(2, Math.max(a, b));
		ResultSet rs = ps.executeQuery();

		int count = 0;
		while(rs.next()) {
			System.out.print(rs.getString("menu_name"));
			System.out.print(" / ");
			System.out.print(rs.getInt("menu_price"));
			System.out.print(" / ");
			System.out.println(rs.getString("menu_type"));
			count++;
		}

		System.out.println("총 "+count+"개의 결과");
		con.close();
	}
}
