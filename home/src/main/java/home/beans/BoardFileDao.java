package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardFileDao {

	//파일 정보 저장 기능
	public void insert(BoardFileDto boardFileDto) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "insert into board_file values(board_file_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardFileDto.getBoardNo());
		ps.setString(2, boardFileDto.getBoardFileUploadname());
		ps.setString(3, boardFileDto.getBoardFileSavename());
		ps.setLong(4, boardFileDto.getBoardFileSize());
		ps.setString(5, boardFileDto.getBoardFileType());
		ps.execute();

		con.close();
	}

	//단일조회
	public BoardFileDto get(int boardFileNo) throws Exception{
		Connection con = JdbcUtils.connect2();

		String sql = "select * from board_file where board_file_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardFileNo);
		ResultSet rs = ps.executeQuery();

		BoardFileDto boardFileDto;
		if(rs.next()) {
			boardFileDto = new BoardFileDto();

			//copy
			boardFileDto.setBoardFileNo(rs.getInt("board_file_no"));
			boardFileDto.setBoardNo(rs.getInt("board_no"));
			boardFileDto.setBoardFileSavename(rs.getString("board_file_savename"));
			boardFileDto.setBoardFileUploadname(rs.getString("board_file_uploadname"));
			boardFileDto.setBoardFileType(rs.getString("board_file_type"));
			boardFileDto.setBoardFileSize(rs.getLong("board_file_size"));
		}
		else {
			boardFileDto = null;
		}

		con.close();

		return boardFileDto;
	}

	//게시글에 해당하는 파일목록 조회
	public List<BoardFileDto> find(int boardNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from board_file where board_no = ? order by board_file_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();

		List<BoardFileDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardFileDto boardFileDto = new BoardFileDto();

			//copy
			boardFileDto.setBoardFileNo(rs.getInt("board_file_no"));
			boardFileDto.setBoardNo(rs.getInt("board_no"));
			boardFileDto.setBoardFileSavename(rs.getString("board_file_savename"));
			boardFileDto.setBoardFileUploadname(rs.getString("board_file_uploadname"));
			boardFileDto.setBoardFileType(rs.getString("board_file_type"));
			boardFileDto.setBoardFileSize(rs.getLong("board_file_size"));

			list.add(boardFileDto);
		}

		con.close();

		return list;
	}
	
}
