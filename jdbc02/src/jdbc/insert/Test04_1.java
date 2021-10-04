package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String student = sc.next();
		System.out.print("과목 : ");
		String subject = sc.next();
		System.out.print("유형 : ");
		String type = sc.next();
		System.out.print("점수 : ");
		int score = sc.nextInt();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

//		String sql = "insert into exam values(exam_seq.nextval, '또가스', 'SQL활용', '서술형', 70)";
		String sql = "insert into exam values(exam_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student);
		ps.setString(2, subject);
		ps.setString(3, type);
		ps.setInt(4, score);
		ps.execute();

		con.close();
		System.out.println("등록이 완료되었습니다");
	}
}
