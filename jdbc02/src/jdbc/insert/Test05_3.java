package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test05_3 {
	public static void main(String[] args) throws Exception {
		// 준비 : 등록에 필요한 데이터
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int no = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("종류 : ");
		String type = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("생산날짜 : ");
		String made = sc.next();
		System.out.print("유통기한 : ");
		String expire = sc.next();

		sc.close();

		// 처리 : 데이터베이스 등록
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "insert into product values(" + "?,"
				+ "?, ?, ?, to_date(?, 'YYYY-MM-DD'), to_date(?, 'YYYY-MM-DD')" + ")";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setString(3, type);
		ps.setInt(4, price);
		ps.setString(5, made);
		ps.setString(6, expire);
		ps.execute();

		con.close();

		// 완료 : 메세지 출력
		System.out.println("등록 완료!");
	}
}
