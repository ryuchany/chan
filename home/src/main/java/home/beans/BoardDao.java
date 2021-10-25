package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public static final String USERNAME = "kh", PASSWORD = "0000";
	
//	목록 조회 기능
	public List<BoardDto> list() throws Exception {

		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from board order by board_no desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs의 내용을 List에 복사
		List<BoardDto> list = new ArrayList<>();
		while (rs.next()) {
			BoardDto boardDto = new BoardDto();

			// (5개 항목 복사)
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardTime(rs.getDate("board_time"));

			list.add(boardDto);
		}

		con.close();

		return list;
	}
	
	
	//작성
	public void write(BoardDto boardDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into board(board_no, board_writer, board_title, board_content) values(board_seq.nextval, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDto.getBoardWriter());
		ps.setString(2, boardDto.getBoardTitle());
		ps.setString(3, boardDto.getBoardContent());
		ps.execute();

		con.close();
	}
	
//	게시글 상세 보기
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
		}
		else {
			boardDto = null;
		}

		con.close();

		return boardDto;
	}
	
	//삭제
	public boolean delete(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete board where board_writer = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	public boolean delete(int boardNo) throws Exception {
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

//	게시판 수정 기능
	public boolean edit(BoardDto boardDto) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update board set board_title=?, board_content = ? where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDto.getBoardTitle());
		ps.setString(2, boardDto.getBoardContent());
		ps.setInt(3, boardDto.getBoardNo());

		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
}
