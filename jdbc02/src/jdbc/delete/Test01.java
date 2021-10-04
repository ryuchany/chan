package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws Exception {
		// 사용자에게 상품번호(no)를 입력받아서 product 테이블에서 해당하는 상품번호 데이터를 삭제

		Scanner sc = new Scanner(System.in);
		System.out.print("상품번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");

		String sql = "delete from product where no = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);

//		ps.execute();

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println(count + "개의 상품이 삭제 되었습니다.");
		} else {
			System.out.println("상품이 존재하지 않습니다.");
		}

		ps.close();
		con.close();

	}
}
