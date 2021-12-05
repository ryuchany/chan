package com.kh.spring09.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring09.entity.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(ProductDto productDto) {
		String sql = "insert into product values(" + "product_seq.nextval, ?, ?, ?, "
				+ "to_date(?, 'YYYY-MM-DD'), to_date(?, 'YYYY-MM-DD'))";
		Object[] param = { productDto.getName(), productDto.getType(), productDto.getPrice(), productDto.getMade(),
				productDto.getExpire() };
		jdbcTemplate.update(sql, param);
	}

	
	@Override
	public List<ProductDto> list() {
		String sql = "select * from product";

		RowMapper<ProductDto> converter = new RowMapper<ProductDto>() {
			@Override
			public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDto productDto = new ProductDto();

				productDto.setNo(rs.getInt("no"));
				productDto.setName(rs.getString("name"));
				productDto.setType(rs.getString("type"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setMade(rs.getString("made"));
				productDto.setExpire(rs.getString("expire"));

				return productDto;
			}
		};
		return jdbcTemplate.query(sql, converter);

	}
}
