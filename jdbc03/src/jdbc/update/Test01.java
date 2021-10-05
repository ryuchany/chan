package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		
		//준비
		int no = 2;
		int price = 2500;

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");	

		String sql = "update product set price = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, no);
		int count = ps.executeUpdate();

		con.close();

		//출력
		if(count > 0) {
			System.out.println("가격 변경이 완료되었습니다");
		}
		else {
			System.out.println("존재하지 않는 상품 번호입니다");
		}

	}
}


