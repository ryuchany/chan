package jdbc.select2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.JdbcUtils;

public class Test02_1 {
	public static void main(String[] args) throws Exception {

		int exam_id = 10;

		// 처리
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "select * from exam where exam_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, exam_id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {// 있으면
			System.out.print(rs.getInt("exam_id"));
			System.out.print(" / ");
			System.out.print(rs.getString("student"));
			System.out.print(" / ");
			System.out.print(rs.getString("subject"));
			System.out.print(" / ");
			System.out.print(rs.getString("type"));
			System.out.print(" / ");
			System.out.println(rs.getInt("score"));
		} else {// 없으면
			System.out.println("찾으시는 번호의 학생이 없습니다.");
		}

		con.close();

	}
}
