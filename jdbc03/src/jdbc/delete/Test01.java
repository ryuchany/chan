package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Q : 상품번호(no)를 입력받아 상품정보(product) 삭제

		//입력
		int no = 3;

		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "delete product where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, no);

		//ps.execute();//해당 명령으로는 삭제가 성공했는지 실패했는지 파악할 수 없다.
		int count = ps.executeUpdate();//해당 명령은 실행 후 적용된 행 개수를 반환한다.

		con.close();

		//결과 
		System.out.println("count = " + count);
		if(count > 0) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("해당하는 상품이 존재하지 않습니다");
		}


	}
}
