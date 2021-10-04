package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test05_1 {
	public static void main(String[] args) throws Exception {
		//준비 : 등록에 필요한 데이터
		String name = "메로나튜브";
		String type = "아이스크림";
		int price = 1200;
		String made = "2021-10-04";
		String expire = "2022-04-03";

		//처리 : 데이터베이스 등록
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "insert into product values("
									+ "product_seq.nextval,"
									+ "?, ?, ?, to_date(?, 'YYYY-MM-DD'), to_date(?, 'YYYY-MM-DD')"
							+ ")";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, price);
		ps.setString(4, made);
		ps.setString(5, expire);
		ps.execute();

		con.close();

		//완료 : 메세지 출력
		System.out.println("등록 완료!");
	}
}
