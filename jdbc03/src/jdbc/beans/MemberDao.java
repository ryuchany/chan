package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.util.JdbcUtils;

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

}
