package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public static final String USERNAME = "kh", PASSWORD = "0000";
	
	//목록기능
	public List<BoardDto> list() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from board order by board_no desc";//최신순 - board_no가 pk라서 인덱스를 갖는다- 순서
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<BoardDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();

			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			boardDto.setBoardSuperno(rs.getInt("board_superno"));
			boardDto.setBoardGroupno(rs.getInt("board_groupno"));
			boardDto.setBoardDepth(rs.getInt("board_depth"));

			list.add(boardDto);
		}

		con.close();

		return list;
	}
	
	//검색기능
	public List<BoardDto> search(String column, String keyword) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from board where instr(#1, ?) > 0 order by board_no desc"; 
		sql = sql.replace("#1", column);//정적 바인딩
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		List<BoardDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();

			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			boardDto.setBoardSuperno(rs.getInt("board_superno"));
			boardDto.setBoardGroupno(rs.getInt("board_groupno"));
			boardDto.setBoardDepth(rs.getInt("board_depth"));

			list.add(boardDto);
		}

		con.close();

		return list;
	}
	
	
	//상세보기 기능
	public BoardDto get(int boardNo) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from board where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();

		BoardDto boardDto;
		if(rs.next()) {
			boardDto = new BoardDto();

			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			boardDto.setBoardSuperno(rs.getInt("board_superno"));
			boardDto.setBoardGroupno(rs.getInt("board_groupno"));
			boardDto.setBoardDepth(rs.getInt("board_depth"));
		}
		else {
			boardDto = null;
		}

		con.close();

		return boardDto;
	}

	//조회수 증가 기능
	public boolean readUp(int boardNo) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update board set board_read = board_read + 1 where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	//남의 글일 경우에만 조회수를 증가하는 기능
	public boolean readUp(int boardNo, String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update board "
							+ "set board_read = board_read + 1 "
							+ "where board_no = ? and board_writer != ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ps.setString(2, memberId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	//등록 기능
	public void write(BoardDto boardDto) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0, 0, 0, 0, 0)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDto.getBoardWriter());
		ps.setString(2, boardDto.getBoardTitle());
		ps.setString(3, boardDto.getBoardContent());
		ps.execute();

		con.close();
	}
	
	//번호 생성 기능 : 번호를 미리 생성해두어야 할 필요가 있는 경우 사용
	public int getSequence() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();

		rs.next();
		//int seq = rs.getInt("nextval");
		int seq = rs.getInt(1);

		con.close();

		return seq;
	}

	//등록 기능2 : 번호를 미리 생성해놓은 경우의 추가 기능
	public void write2(BoardDto boardDto) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into board values(?, ?, ?, ?, sysdate, 0, 0, 0, 0, 0)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardDto.getBoardNo());
		ps.setString(2, boardDto.getBoardWriter());
		ps.setString(3, boardDto.getBoardTitle());
		ps.setString(4, boardDto.getBoardContent());
		ps.execute();

		con.close();
	}
	
	//삭제
//	public boolean delete(String memberId) throws Exception {
//		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
//
//		String sql = "delete board where board_writer = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, memberId);
//		int result = ps.executeUpdate();
//
//		con.close();
//
//		return result > 0;
//	}
	
	//삭제 기능
	public boolean delete(int boardNo) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete board where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	public boolean delete(String memberId, int boardNo) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete board where board_writer = ? and board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setInt(2, boardNo);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

	//수정 기능
	public boolean edit(BoardDto boardDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update board set board_title=?, board_content=? where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDto.getBoardTitle());
		ps.setString(2, boardDto.getBoardContent());
		ps.setInt(3, boardDto.getBoardNo());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
}
