package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	
	public static Connection connect(String username, String password) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","0000");
		return con;
	}
}
