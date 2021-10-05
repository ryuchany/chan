package jdbc.select;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test03_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//product 조회
		//= select * from product;

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.println("데이터 발견!");
			int no = rs.getInt("no");//rs.getInt(1)
			String name = rs.getString("name");//rs.getString(2)
			String type = rs.getString("type");//rs.getString(3)
			int price = rs.getInt("price");//rs.getInt(4)
			String made = rs.getString("made");//rs.getString(5)
			String expire = rs.getString("expire");//rs.getString(6)

			System.out.println("no = " + no);
			System.out.println("name = " + name);
			System.out.println("type = " + type);
			System.out.println("price = " + price);
			System.out.println("made = " + made);
			System.out.println("expire = " + expire);
		}

		con.close();
	}
}
