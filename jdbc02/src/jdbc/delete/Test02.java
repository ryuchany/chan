package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws Exception {
		// 사용자에게 아이디(memberId)와 비밀번호(memberPw)를 입력받아 일치하는 회원 정보를 삭제
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String memberId = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String memberPw = sc.next();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "delete from member where  member_id = ? and member_pw = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("아이디가 삭제 되었습니다.");
		} else {
			System.out.println("잘못 입력했습니다.");
		}

		ps.close();
		con.close();

	}
}
