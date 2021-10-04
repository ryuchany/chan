package jdbc.insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test05_2 {
	public static void main(String[] args) throws Exception {
		//준비 : 등록에 필요한 데이터
		//= 데이터베이스의 DATE 형태와 연동되려면 java.sql.Date 형태를 사용해야 한다.
		//= java.util.Date 가 아니라는 사실을 주의해야 한다.

		String name = "메로나튜브";
		String type = "아이스크림";
		int price = 1200;
		String made = "2021-10-04";
		String expire = "2022-04-03";

		//java.sql.Date로 변환
		int madeYear = Integer.parseInt(made.substring(0, 4));
		int madeMonth = Integer.parseInt(made.substring(5, 7));
		int madeDay = Integer.parseInt(made.substring(8));
		int expireYear = Integer.parseInt(expire.substring(0, 4));
		int expireMonth = Integer.parseInt(expire.substring(5, 7));
		int expireDay = Integer.parseInt(expire.substring(8)); 

		//Date madeDate = new Date(연-1900, 월-1, 일);
		Date madeDate = new Date(madeYear-1900, madeMonth-1, madeDay);
		//Date expireDate = new Date(연-1900, 월-1, 일);
		Date expireDate = new Date(expireYear-1900, expireMonth-1, expireDay);

		//처리 : 데이터베이스 등록
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "insert into product values("
									+ "product_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, price);
		ps.setDate(4, madeDate);
		ps.setDate(5, expireDate);
		ps.execute();

		con.close();

		//완료 : 메세지 출력
		System.out.println("등록 완료!");
	}
}
