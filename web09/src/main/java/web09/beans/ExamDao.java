package web09.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Exam 테이블에 대한 데이터베이스 작업을 처리하는 클래스
//= DAO : Data Access Object (ex : 택배기사님)
//= 각각의 작업(CRRUD)들을 메소드 단위로 보관하고 호출하여 사용
public class ExamDao {

	public static final String USERNAME = "kh";
	public static final String PASSWORD = "0000";

	// [1] 등록(Create) 메소드
	// = insert into exam(형식) values(번호, 이름, 과목, 유형, 점수)
	// = insert into exam(형식) values(exam_seq.nextval, ?, ?, ?, ?)
	public void insert(String student, String subject, String type, int score) throws Exception {
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "insert into exam values(exam_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student);
		ps.setString(2, subject);
		ps.setString(3, type);
		ps.setInt(4, score);
		ps.execute();

		con.close();

	}

	// [1] 등록(Create) 메소드
	// = 낱개 데이터가 아닌 의미있는 단위(객체)로 데이터를 전달받도록 구현
	public void insert(ExamDto examDto) throws Exception {
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "insert into exam values(exam_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, examDto.getStudent());
		ps.setString(2, examDto.getSubject());
		ps.setString(3, examDto.getType());
		ps.setInt(4, examDto.getScore());
		ps.execute();

		con.close();

	}

	// [2] 수정(Update) 메소드
	// = update exam set student=?, subject=?, type=?, score=? where exam_id=?
	// = 준비물(매개변수) : ExamDto
	// = 결과물(반환형) : boolean
	public boolean update(ExamDto examDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update exam set student=?, subject=?, type=?, score=? where exam_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, examDto.getStudent());
		ps.setString(2, examDto.getSubject());
		ps.setString(3, examDto.getType());
		ps.setInt(4, examDto.getScore());
		ps.setInt(5, examDto.getExamId());
		int result = ps.executeUpdate();// 실행

		con.close();

//		result가 0보다 크다면 성공(true)했음을, 아니라면 실패(false)했음을 보고해라!
//		if(result > 0) {
//			return true;
//		}
//		else {
//			return false;
//		}

//		result가 0보다 큰지 판단해서 보고해라!
		return result > 0;
	}

//	[3] 이름만 수정하는 메소드
//	= update exam set student = ? where exam_id = ?
//	= 준비물 : ExamDto
//	= 결과물 : boolean
	public boolean updateStudent(ExamDto examDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update exam set student=? where exam_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, examDto.getStudent());
		ps.setInt(2, examDto.getExamId());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

// [4] 데이터를 삭제하는 메소드
// = PK를 이용하여 1개의 데이터를 삭제
// = 매개변수 : Primary Key(시험지번호, exam_id) int
// = 반환형 : boolean
	public boolean delete(int examId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete exam where exam_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, examId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;

	}

//	[5] 목록조회(R) 메소드(+검색)
//	= 여러 개의 데이터가 나오는 메소드
//	= select * from exam
//	= 매개변수 : 없음
//	= 반환형 : 시험지 목록(List<ExamDto>)
	public List<ExamDto> select() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from exam";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs에 들어있는 데이터를 새로 만든 List에 복사하여 반환
		List<ExamDto> list = new ArrayList<>();// 1. 비어있는 List를 생성한다.

		while (rs.next()) {// 2. 데이터 개수만큼 반복을 수행한다.
			// 3. 한 줄씩 하나의 객체에 복사한다
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));// rs의 exam_id를 객체에 복사
			examDto.setStudent(rs.getString("student"));// rs의 student를 객체에 복사
			examDto.setSubject(rs.getString("subject"));// rs의 subject를 객체에 복사
			examDto.setType(rs.getString("type"));// rs의 type을 객체에 복사
			examDto.setScore(rs.getInt("score"));// rs의 score를 객체에 복사

			// 4. 만들어진 객체를 List에 추가한다.
			list.add(examDto);
		}

		con.close();

		return list;
	}

//	[6] 검색(R) 메소드
//	= 검색은 목록과 유사(데이터가 여러 개 나옴)
//	= 어떤 항목으로 검색할 것인지 정해야 한다.
//	= 학생 이름으로 검색한 결과를 출력하도록 구현(다른 형태도 가능)
//	= 매개변수 : 학생이름(String)
//	= 반환형 : 시험지정보목록(List<ExamDto>)
	public List<ExamDto> selectByStudent(String student) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from exam " + "where student = ? " + "order by exam_id asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student);
		ResultSet rs = ps.executeQuery();

		// rs에 들어있는 데이터를 새로 만든 List에 복사하여 반환
		List<ExamDto> list = new ArrayList<>();// 1. 비어있는 List를 생성한다.

		while (rs.next()) {// 2. 데이터 개수만큼 반복을 수행한다.
			// 3. 한 줄씩 하나의 객체에 복사한다
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));// rs의 exam_id를 객체에 복사
			examDto.setStudent(rs.getString("student"));// rs의 student를 객체에 복사
			examDto.setSubject(rs.getString("subject"));// rs의 subject를 객체에 복사
			examDto.setType(rs.getString("type"));// rs의 type을 객체에 복사
			examDto.setScore(rs.getInt("score"));// rs의 score를 객체에 복사

			// 4. 만들어진 객체를 List에 추가한다.
			list.add(examDto);
		}

		con.close();

		return list;
	}

// [7] 항목(column)과 검색어(keyword)를 이용한 검색 메소드	
// = (주의) 항목은 홀더처리하면 안된다	
	public List<ExamDto> select(String column, String keyword) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

//		String sql = "select * from exam where #1 = ? order by #1 asc";
		String sql = "select * from exam where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", column);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		// rs에 들어있는 데이터를 새로 만든 List에 복사하여 반환
		List<ExamDto> list = new ArrayList<>();// 1. 비어있는 List를 생성한다.

		while (rs.next()) {// 2. 데이터 개수만큼 반복을 수행한다.
			// 3. 한 줄씩 하나의 객체에 복사한다
			ExamDto examDto = new ExamDto();
			examDto.setExamId(rs.getInt("exam_id"));// rs의 exam_id를 객체에 복사
			examDto.setStudent(rs.getString("student"));// rs의 student를 객체에 복사
			examDto.setSubject(rs.getString("subject"));// rs의 subject를 객체에 복사
			examDto.setType(rs.getString("type"));// rs의 type을 객체에 복사
			examDto.setScore(rs.getInt("score"));// rs의 score를 객체에 복사

			// 4. 만들어진 객체를 List에 추가한다.
			list.add(examDto);
		}

		con.close();

		return list;

	}

//	[8] 단일조회(R) 메소드
//	= 결과가 1개 또는 0개로 나오는 메소드
//	= 매개변수 : 시험지번호(exam_id, int)
//	= 반환형 : 시험지정보(ExamDto)
//	= select * from exam where exam_id = ?
	public ExamDto select(int examId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from exam where exam_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, examId);
		ResultSet rs = ps.executeQuery();

		// copy
		// ExamDto examDto = 객체 or null;
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

		con.close();

		return examDto;
	}
}
