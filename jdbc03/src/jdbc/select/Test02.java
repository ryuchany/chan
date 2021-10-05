package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//exam 테이블 조회
		//= select * from exam;

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from exam";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.println(rs.getInt(1));		//rs.getInt("exam_id")
			System.out.println(rs.getString(2));	//rs.getString("student")
			System.out.println(rs.getString(3));	//rs.getString("subject")
			System.out.println(rs.getString(4));	//rs.getString("type")
			System.out.println(rs.getInt(5));		//rs.getInt("score")
		}

		con.close();
	}
}
