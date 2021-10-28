package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TotalHistoryDao {
	
	//회원의 포인트내역 조회 기능
	//= HistoryDto 대신에 취소 여부도 알 수 있도록 새로 만든 TotalHistoryDto를 사용하여 조회
	public List<TotalHistoryDto> findByMemberId(String memberId) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from total_history where member_id = ? order by history_no desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();

		//copy(rs --> List<TotalHistoryDto>)
		List<TotalHistoryDto> list = new ArrayList<>();
		while(rs.next()) {
			TotalHistoryDto historyDto = new TotalHistoryDto();

			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setMemberId(rs.getString("member_id"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryMemo(rs.getString("history_memo"));
			historyDto.setHistoryAmount(rs.getInt("history_amount"));
			historyDto.setCancel(rs.getString("cancel"));

			list.add(historyDto);
		}

		con.close();

		return list;
	}
}
