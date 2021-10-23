package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//member 테이블에 접근하는 객체
public class MemberDao {

	public static final String USERNAME = "kh", PASSWORD = "0000";

	//[1] 회원가입 메소드
	public void join(MemberDto memberDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "insert into member("
								+ "member_id, member_pw, member_nick, "
								+ "member_birth, member_email, member_phone"
							+ ") "
							+ "values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?)";
//		String sql = "insert into member values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 100, '준회원')";
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
	public boolean edit(MemberDto memberDto) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member "
							+ "set "
								+ "member_nick = ?, "
								+ "member_birth = to_date(?, 'YYYY-MM-DD'),"
								+ "member_email = ?,"
								+ "member_phone = ? "
							+ "where "
								+ "member_id = ? and member_pw = ?";
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
		ps.setString(1, changePw);//바꿀비밀번호
		ps.setString(2, memberId);//현재아이디
		ps.setString(3, memberPw);//현재비밀번호
		int result = ps.executeUpdate();

		con.close();

		return result > 0;		
	}

//	비밀번호 변경 기능2
	public boolean editPassword(MemberDto memberDto, String changePw) throws Exception {
		//위 메소드 실행 결과를 반환해라!
		return editPassword(memberDto.getMemberId(), memberDto.getMemberPw(), changePw);
	}

//	회원 탈퇴 기능
	public boolean quit(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	public boolean quit(String memberId, String memberPw) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete member where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

	public boolean quit(MemberDto memberDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		StringBuffer buffer = new StringBuffer();
		buffer.append("delete member ");
		buffer.append("where 1=1 ");

		if(memberDto.getMemberId() != null) {
			buffer.append("and member_id = ? ");
		}
		if(memberDto.getMemberPw() != null) {
			buffer.append("and member_pw = ? ");
		}
		if(memberDto.getMemberNick() != null) {
			buffer.append("and member_nick = ? ");
		}
		if(memberDto.getMemberPhone() != null) {
			buffer.append("and member_phone = ? ");
		}
		if(memberDto.getMemberGrade() != null) {
			buffer.append("and member_grade = ? ");
		}

		String sql = buffer.toString();
		System.out.println("sql = " + sql);
		PreparedStatement ps = con.prepareStatement(sql);

		int index = 1;
		if(memberDto.getMemberId() != null) {
			ps.setString(index++, memberDto.getMemberId());
		}
		if(memberDto.getMemberPw() != null) {
			ps.setString(index++, memberDto.getMemberPw());
		}
		if(memberDto.getMemberNick() != null) {
			ps.setString(index++, memberDto.getMemberNick());
		}
		if(memberDto.getMemberPhone() != null) {
			ps.setString(index++, memberDto.getMemberPhone());
		}
		if(memberDto.getMemberGrade() != null) {
			ps.setString(index++, memberDto.getMemberGrade());
		}

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

		//rs의 내용을 List에 복사
		List<MemberDto> memberList = new ArrayList<>();
		while(rs.next()) {
			MemberDto memberDto = new MemberDto();

			//(9개 항목 복사)
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));

			memberList.add(memberDto);
		}

		con.close();

		return memberList;
	}

//	회원검색 기능
	public List<MemberDto> search(String column, String keyword) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", column);//정적 치환
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);//동적 치환
		ResultSet rs = ps.executeQuery();

		//copy
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto memberDto = new MemberDto();

			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));

			list.add(memberDto);
		}

		con.close();

		return list;
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
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));
		}
		else {
			memberDto = null;
		}

		con.close();

		return memberDto;
	}
	
	public boolean addPoint(String memberId, int coinAmount) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member "
							+ "set member_point = member_point + ? "
							+ "where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, coinAmount);
		ps.setString(2, memberId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

	public boolean refreshPoint(String memberId) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member set member_point = ("
				+ "select sum(history_amount) from total_history_record where member_id = ?"
							+ ") where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberId);
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	//관리자용 수정 기능
	public boolean editByAdmin(MemberDto memberDto) throws Exception{
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update member "
								+ "set "
										+ "member_nick=?, "
										+ "member_birth=to_date(?, 'YYYY-MM-DD'), "
										+ "member_email=?, "
										+ "member_phone=?, "
										+ "member_point=?, "
										+ "member_grade=? "
								+ "where member_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDto.getMemberNick());
		ps.setString(2, memberDto.getMemberBirth());
		ps.setString(3, memberDto.getMemberEmail());
		ps.setString(4, memberDto.getMemberPhone());
		ps.setInt(5, memberDto.getMemberPoint());
		ps.setString(6, memberDto.getMemberGrade());
		ps.setString(7, memberDto.getMemberId());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}
	
	//회원등급별 포인트 보유량 조회 기능(통계기능)
	//= MemberDto 외에 필요한 내용이 있다면 별도의 클래스를 만들어서 처리
	//= DTO는 테이블과 동일한 형태로 만들어야 한다.
	//= 이러한 경우 DTO 말고 VO를 만들어서 사용한다(Value Object)
	//= VO는 자유로운 형태로 만들 수 있다.
	//= DTO와 VO를 구분하지 않는 경우도 많이 있다.
	public List<GroupPointVO> pointByGrade() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select member_grade, sum(member_point) total from member "
									+ "group by member_grade order by total desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<GroupPointVO> list = new ArrayList<>();
		while(rs.next()) {
			GroupPointVO vo = new GroupPointVO();
			vo.setMemberGrade(rs.getString("member_grade"));
			vo.setTotal(rs.getInt("total"));
			list.add(vo);
		}

		con.close();

		return list;
	}

//	추가 기능에 대한 아이디어
//	- 로그인 기능(Read)
//	- 포인트 증가 혹은 감소 기능(Update)
//	- 등급변경 기능(Update)
//	- 최종 접속시각 기록(Update or Create)
//		1. 마지막 접속시각만 알고 싶고 나머진 다 없어져도 되면 컬럼 1개를 추가하여 해결
//		2. 여태까지의 모든 접속시각을 알고 싶다면 기록할 하위테이블을 하나 만들어서 해결
}
