package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");
		
		//database에 insert 명령을 전송하여 데이터를 추가하도록 지시
		
		//1. 명령문 준비
		String sql = "insert into menu(menu_name, menu_price, menu_type) "
				+ "values('갈치조림', 7000, '식사')";
		
		//2. 전송객체 대여
		PreparedStatement ps = con.prepareStatement(sql);
		
		//3. 실행
		ps.execute();
		
		con.close();
		System.out.println("실행 완료!");

		
				
	}

}
