package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao {

	//특정 게시글에 대한 댓글 목록 조회 기능
	public List<ReplyDto> list(int boardNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from reply where board_no = ? order by reply_no desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();

		List<ReplyDto> list = new ArrayList<>();
		while(rs.next()) {
			ReplyDto replyDto = new ReplyDto();

			replyDto.setReplyNo(rs.getInt("reply_no"));
			replyDto.setBoardNo(rs.getInt("board_no"));
			replyDto.setReplyWriter(rs.getString("reply_writer"));
			replyDto.setReplyContent(rs.getString("reply_content"));
			replyDto.setReplyTime(rs.getDate("reply_time"));
			replyDto.setReplySuperno(rs.getInt("reply_superno"));
			replyDto.setReplyGroupno(rs.getInt("reply_groupno"));
			replyDto.setReplyDepth(rs.getInt("reply_depth"));

			list.add(replyDto);
		}

		con.close();

		return list;
	}

	//댓글 등록 기능
		public void insert(ReplyDto replyDto) throws Exception{
			Connection con = JdbcUtils.connect2();

			String sql = "insert into reply values(reply_seq.nextval, ?, ?, ?, sysdate, 0, 0, 0)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, replyDto.getBoardNo());
			ps.setString(2, replyDto.getReplyWriter());
			ps.setString(3, replyDto.getReplyContent());
			ps.execute();

			con.close();
		}
	
		//댓글 삭제
		public boolean delete(int replyNo) throws Exception{
			Connection con = JdbcUtils.connect2();

			String sql = "delete reply where reply_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, replyNo);
			int result = ps.executeUpdate();

			con.close();

			return result > 0;
		}
		
		//댓글 수정
		public boolean edit(ReplyDto replyDto) throws Exception{
			Connection con = JdbcUtils.connect2();

			String sql = "update reply set reply_content = ? where reply_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, replyDto.getReplyContent());
			ps.setInt(2, replyDto.getReplyNo());
			int result = ps.executeUpdate();

			con.close();

			return result > 0;
		}
		
}
