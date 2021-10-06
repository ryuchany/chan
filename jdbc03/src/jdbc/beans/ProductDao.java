package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.util.JdbcUtils;

public class ProductDao {
	public void insert(int no, String name, String type, int price, String made, String expire) throws Exception {
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "insert into product values(?, ?, ?, ?, ?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setString(3, type);
		ps.setInt(4, price);
		ps.setString(5, made);
		ps.setString(6, expire);
		ps.execute();

		con.close();
	}
}
