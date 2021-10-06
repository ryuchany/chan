package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09 {
	public static void main(String[] args) throws Exception {
		// Q : product 테이블에서 원하는 항목에 맞는 검사를 수행
		// = 원하는 항목은 이름, 분류

		// 입력
		String kind = "name";
		String keyword = "바";

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		if (kind.equals("name")) {
			String sql = "select  * from product where instr(name, ?) >0 ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(" / ");
				System.out.print(rs.getString("type"));
				System.out.print(" / ");
				System.out.print(rs.getInt("price"));
				System.out.println();
			}
		} else if (kind.equals("type")) {
			String sql = "select  * from product where instr(type, ?) >0 ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(" / ");
				System.out.print(rs.getString("type"));
				System.out.print(" / ");
				System.out.print(rs.getInt("price"));
				System.out.println();
			}
		}

		con.close();

	}
}
