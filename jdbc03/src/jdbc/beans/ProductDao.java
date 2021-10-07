package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.util.JdbcUtils;

public class ProductDao {

	public static final String USERNAME = "kh";
	public static final String PASSWORD = "0000";

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

	public void insert(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "insert into product values(?, ?, ?, ?, to_date(?,'YYYY-MM-dd'), to_date(?,'YYYY-MM-dd'))";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, productDto.getNo());
		ps.setString(2, productDto.getName());
		ps.setString(3, productDto.getType());
		ps.setInt(4, productDto.getPrice());
		ps.setString(5, productDto.getMade());
		ps.setString(6, productDto.getExpire());
		ps.execute();

		con.close();
	}

	public boolean update(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update product set name = ? , type = ? , price = ?, made = to_date(?,'YYYY-MM-dd') , expire = to_date(?,'YYYY-MM-dd') where no = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, productDto.getName());
		ps.setString(2, productDto.getType());
		ps.setInt(3, productDto.getPrice());
		ps.setString(4, productDto.getMade());
		ps.setString(5, productDto.getExpire());
		ps.setInt(6, productDto.getNo());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;

	}

	public boolean updatePrice(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update product set price=? where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, productDto.getPrice());
		ps.setInt(2, productDto.getNo());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

}
