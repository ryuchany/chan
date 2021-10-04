package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02_3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 이름 : ");
		String menuName = sc.nextLine();
		System.out.print("메뉴 가격 : ");
		int menuPrice = sc.nextInt();
		sc.nextLine();
		System.out.print("메뉴 유형 : ");
		String menuType = sc.nextLine();
		sc.close();

		//Q : 위 변수에 저장된 값이 menu 테이블에 insert 될 수 있도록 JDBC 구문을 작성해보세요.
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
										"jdbc:oracle:thin:@localhost:1521:xe", "kh", "0000");
		con.setAutoCommit(false);//자동커밋 해제

		String sql = "insert into menu(menu_name, menu_price, menu_type) "
				+ "values('"+menuName+"', "+menuPrice+", '"+menuType+"')";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();

		con.rollback();
//		con.commit();

		con.close();
		System.out.println("등록 완료");
	}
}