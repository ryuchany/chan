package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String menuName = "오므라이스";
		String menuType = "식사";
		int menuPrice = 8500;

		//Q : 위 변수에 저장된 값이 menu 테이블에 insert 될 수 있도록 JDBC 구문을 작성해보세요.
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
										"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into menu(menu_name, menu_price, menu_type)");
		buffer.append(" ");
		buffer.append("values");
		buffer.append("(");
		buffer.append("'");
		buffer.append(menuName);
		buffer.append("'");
		buffer.append(",");
		buffer.append(menuPrice);
		buffer.append(",");
		buffer.append("'");
		buffer.append(menuType);
		buffer.append("'");
		buffer.append(")");
		String sql = buffer.toString();
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();

		con.close();
		System.out.println("등록 완료");
	}
}
