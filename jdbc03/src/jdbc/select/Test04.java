package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//member 조회하는 방법
		//1. 애초에 구문에서 중요정보를 제외하고 조회하는 방법 (안정성↑)
		//2. 전체 조회 후 원하는 정보만 출력 (확장성↑)

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			System.out.println("데이터 발견");
			System.out.println("아이디 : "+rs.getString("member_id"));
			//System.out.println("비밀번호 : "+rs.getString("member_pw"));
			System.out.println("닉네임 : "+rs.getString("member_nick"));
			System.out.println("생년월일 : "+rs.getDate("member_birth"));
			System.out.println("이메일 : "+rs.getString("member_email"));
			System.out.println("전화번호 : "+rs.getString("member_phone"));
			System.out.println("가입일 : "+rs.getDate("member_join"));
			System.out.println("포인트 : "+rs.getInt("member_point"));
			System.out.println("등급 : "+rs.getString("member_grade"));
		}
		con.close();
	}
}
