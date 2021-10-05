package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//exam 테이블 조회
		//= select * from exam;

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select "
								+ "exam_id \"번호\", "
								+ "student \"학생명\", "
								+ "subject \"과목\", "
								+ "type \"유형\", "
								+ "score \"점수\" "
							+ "from exam";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.println(rs.getInt(1));		//rs.getInt("번호")
			System.out.println(rs.getString(2));	//rs.getString("학생명")
			System.out.println(rs.getString(3));	//rs.getString("과목")
			System.out.println(rs.getString(4));	//rs.getString("유형")
			System.out.println(rs.getInt(5));		//rs.getInt("점수")
		}

		con.close();
	}
}
