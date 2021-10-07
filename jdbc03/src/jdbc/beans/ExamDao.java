package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.util.JdbcUtils;

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

}
