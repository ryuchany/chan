package home.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {

	public static final String USERNAME = "kh", PASSWORD = "0000";

	public void insert(HistoryDto historyDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into history values(history_seq.nextval, ?, sysdate, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, historyDto.getMemberId());
		ps.setString(2, historyDto.getHistoryMemo());
		ps.setInt(3, historyDto.getHistoryAmount());
		ps.execute();

		con.close();
	}
	
	//회원의 포인트내역 조회 기능
	public List<HistoryDto> findByMemberId(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from history where member_id = ? order by history_no desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();

		//copy(rs --> List<HistoryDto>)
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {
			HistoryDto historyDto = new HistoryDto();

			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setMemberId(rs.getString("member_id"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryMemo(rs.getString("history_memo"));
			historyDto.setHistoryAmount(rs.getInt("history_amount"));

			list.add(historyDto);
		}

		con.close();

		return list;
	}
	
	public HistoryDto get(int historyNo) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from history where history_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, historyNo);
		ResultSet rs = ps.executeQuery();

		HistoryDto historyDto;
		if(rs.next()) {
			historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setMemberId(rs.getString("member_id"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryMemo(rs.getString("history_memo"));
			historyDto.setHistoryAmount(rs.getInt("history_amount"));
		}
		else {
			historyDto = null;
		}

		con.close();

		return historyDto;
	}
	
}
