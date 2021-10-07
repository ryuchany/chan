package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public boolean delete(int no) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		String sql = "delete product where no = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;

	}

	public List<ProductDto> select() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs에 들어있는 데이터를 새로 만든 List에 복사하여 반환
		List<ProductDto> list = new ArrayList<>();// 1. 비어있는 List를 생성한다.

		while (rs.next()) {// 2. 데이터 개수만큼 반복을 수행한다.
			// 3. 한 줄씩 하나의 객체에 복사한다
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));

			// 4. 만들어진 객체를 List에 추가한다.
			list.add(productDto);
		}

		con.close();

		return list;
	}

}
