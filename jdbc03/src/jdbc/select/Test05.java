package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//조건을 통한 필터링
		//= 목록과 출력 방식이 동일하다.

		//분류에 따른 메뉴 목록 출력

		//입력
		String menuType = "식사";

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from menu where menu_type = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, menuType);
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
