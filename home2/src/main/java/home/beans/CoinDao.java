package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoinDao {

//	목록 조회 기능
	public List<CoinDto> list() throws Exception {

		Connection con = JdbcUtils.connect2();

		String sql = "select * from coin order by coin_amount asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs의 내용을 List에 복사
		List<CoinDto> list = new ArrayList<>();
		while (rs.next()) {
			CoinDto coinDto = new CoinDto();

			// (3개 항목 복사)
			coinDto.setCoinNo(rs.getInt("coin_no"));
			coinDto.setCoinName(rs.getString("coin_name"));
			coinDto.setCoinAmount(rs.getInt("coin_amount"));

			list.add(coinDto);
		}

		con.close();

		return list;
	}
	
	public CoinDto get(int coinNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from coin where coin_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, coinNo);
		ResultSet rs = ps.executeQuery();

		CoinDto coinDto;
		if(rs.next()) {
			coinDto = new CoinDto();

			coinDto.setCoinNo(rs.getInt("coin_no"));
			coinDto.setCoinName(rs.getString("coin_name"));
			coinDto.setCoinAmount(rs.getInt("coin_amount"));
		}
		else {
			coinDto = null;
		}

		con.close();

		return coinDto;
	}
	
	public boolean delete(int coinNo) throws Exception{
		Connection con = JdbcUtils.connect2();

		String sql = "delete coin where coin_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, coinNo);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	public boolean edit(CoinDto coinDto) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "update coin set coin_name = ?, coin_amount = ? where coin_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, coinDto.getCoinName());
		ps.setInt(2, coinDto.getCoinAmount());
		ps.setInt(3, coinDto.getCoinNo());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	public void add(CoinDto coinDto) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "insert into coin(coin_no, coin_name, coin_amount) "
								+ "values(coin_seq.nextval, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, coinDto.getCoinName());
		ps.setInt(2, coinDto.getCoinAmount());
		ps.execute();

		con.close();
	}
	
}
