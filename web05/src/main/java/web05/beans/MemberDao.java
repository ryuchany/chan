package web05.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	public static final String USERNAME = "kh";
	public static final String PASSWORD = "0000";

	public void join(MemberDto memberDto) throws Exception {
		Connection con = JdbcUtils.connect("kh", "0000");

		String sql = "insert into member values(?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, sysdate, 100, '준회원')";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, memberDto.getMemberId());
		ps.setString(2, memberDto.getMemberPw());
		ps.setString(3, memberDto.getMemberNick());
		ps.setString(4, memberDto.getMemberBirth());
		ps.setString(5, memberDto.getMemberEmail());
		ps.setString(6, memberDto.getMemberPhone());
		ps.execute();

		con.close();
	}

//	개인정보 변경 기능
	public boolean edit(MemberDto memberDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member " + "set " + "member_nick = ?, " + "member_birth = ?," + "member_email = ?,"
				+ "member_phone = ? " + "where " + "member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDto.getMemberNick());
		ps.setString(2, memberDto.getMemberBirth());
		ps.setString(3, memberDto.getMemberEmail());
		ps.setString(4, memberDto.getMemberPhone());
		ps.setString(5, memberDto.getMemberId());
		ps.setString(6, memberDto.getMemberPw());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

//	비밀번호 변경 메소드
	public boolean editPassword(String memberId, String memberPw, String changePw) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member set member_pw = ? where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, changePw);// 바꿀비밀번호
		ps.setString(2, memberId);// 현재아이디
		ps.setString(3, memberPw);// 현재비밀번호
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

	public boolean editPassword(MemberDto memberDto, String changePw) throws Exception {
		// 위 메소드 실행 결과를 반환해라!
		return editPassword(memberDto.getMemberId(), memberDto.getMemberPw(), changePw);
	}

	public boolean delete(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		int result = ps.executeUpdate();

		con.close();
		return result > 0;

	}

//	목록 조회 기능
	public List<MemberDto> list() throws Exception {

		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs의 내용을 List에 복사
		List<MemberDto> memberList = new ArrayList<>();
		while (rs.next()) {
			MemberDto memberDto = new MemberDto();

			// (9개 항목 복사)
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberJoin(rs.getString("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));

			memberList.add(memberDto);
		}

		con.close();

		return memberList;
	}

	public List<MemberDto> select(String column, String keyword) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", column);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		List<MemberDto> memberList = new ArrayList<>();

		while (rs.next()) {
			MemberDto memberDto = new MemberDto();

			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberJoin(rs.getString("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));

			memberList.add(memberDto);
		}

		con.close();

		return memberList;

	}

//	회원상세 기능
	public MemberDto get(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();

		MemberDto memberDto;

		if(rs.next()) {
			memberDto = new MemberDto();

			//copy
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberJoin(rs.getString("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));
		}
		else {
			memberDto = null;
		}

		con.close();

		return memberDto;
	}
	
//	추가 기능에 대한 아이디어
//	- 포인트 증가 혹은 감소 기능(Update)
//	- 등급변경 기능(Update)
//	- 최종 접속시각 기록(Update or Create)
//		1. 마지막 접속시각만 알고 싶고 나머진 다 없어져도 되면 컬럼 1개를 추가하여 해결
//		2. 여태까지의 모든 접속시각을 알고 싶다면 기록할 하위테이블을 하나 만들어서 해결
	
}
