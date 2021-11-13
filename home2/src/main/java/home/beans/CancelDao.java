package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CancelDao {

	//1. 결제 취소 기능(C)
	public void insert(int historyNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "insert into cancel values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, historyNo);
		ps.execute();

		con.close();
	}

	//2. 결제 취소 가능 여부 확인 기능(R)
	//= true가 반환되면 데이터가 없어서 결제 취소가 가능하다는 의미이다.
	//= false가 반환되면 데이터가 있어서 결제 취소가 불가능하다는 의미이다.
	public boolean available(int historyNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from cancel where history_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, historyNo);
		ResultSet rs = ps.executeQuery();

		boolean exist = rs.next();

		con.close();

		return !exist;
	}
}
