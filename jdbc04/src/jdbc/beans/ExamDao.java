package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtils;

public class ExamDao {

	public final static String USERNAME = "kh";
	public final static String PASSWORD = "0000";

	// 1.등록(Create) 메소드
	public void insert(ExamDto examDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into exam values (exam_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, examDto.getStudent());
		ps.setString(2, examDto.getSubject());
		ps.setString(3, examDto.getType());
		ps.setInt(4, examDto.getScore());
		ps.execute();

		con.close();

	}

	// 2. 수정(Update) 메소드
	public boolean update(ExamDto examDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update exam set student = ? , subject = ?, type = ? , score = ? where exam_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, examDto.getStudent());
		ps.setString(2, examDto.getSubject());
		ps.setString(3, examDto.getType());
		ps.setInt(4, examDto.getScore());
		ps.setInt(5, examDto.getExamId());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;

	}

	// 3. 삭제(Delete) 메소드
	public boolean delete(int examId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete exam where exam_id  = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, examId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

	// [4] 목록조회(R) 메소드(+검색)
	public List<ExamDto> select() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from exam";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<ExamDto> list = new ArrayList<>();

		while (rs.next()) {
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));
			examDto.setStudent(rs.getString("student"));
			examDto.setSubject(rs.getString("subject"));
			examDto.setType(rs.getString("type"));
			examDto.setScore(rs.getInt("score"));

			list.add(examDto);
		}
		con.close();

		return list;
	}

//	[6] 검색(R) 메소드
	public List<ExamDto> selectByStudent(String student) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		
		String sql = "select * from exam where student = ? order by exam_id asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student);
		ResultSet rs = ps.executeQuery();
		
		List <ExamDto> list = new ArrayList<>();
	
		while (rs.next()) {
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));
			examDto.setStudent(rs.getString("student"));
			examDto.setSubject(rs.getString("subject"));
			examDto.setType(rs.getString("type"));
			examDto.setScore(rs.getInt("score"));

			list.add(examDto);
		}
		con.close();

		return list;
	}
	
//	[7] 항목(column)과 검색어(keyword)를 이용한 검색 메소드	
	public List<ExamDto> select(String column, String keyword) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		
		String sql = "select * from exam where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", column);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<ExamDto> list = new ArrayList<>();
		while (rs.next()) {
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));
			examDto.setStudent(rs.getString("student"));
			examDto.setSubject(rs.getString("subject"));
			examDto.setType(rs.getString("type"));
			examDto.setScore(rs.getInt("score"));

			list.add(examDto);
		}
		con.close();

		return list;
	}
	
//	[8] 단일조회(R) 메소드
	public ExamDto select(int examId) throws Exception{
		
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		
		String sql = "select * from exam where exam_id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, examId);
		ResultSet rs = ps.executeQuery();
		
		ExamDto examDto;
		
		if (rs.next()) {// 있으면
			examDto = new ExamDto();

			examDto.setExamId(rs.getInt("exam_id"));
			examDto.setStudent(rs.getString("student"));
			examDto.setSubject(rs.getString("subject"));
			examDto.setType(rs.getString("type"));
			examDto.setScore(rs.getInt("score"));
		} else {// 없으면
			examDto = null;
		}
		
		return examDto;
	}
	
}
