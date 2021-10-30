package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberProfileDao {
	//프로필 정보 등록
	public void insert(MemberProfileDto memberProfileDto) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "insert into member_profile values(member_profile_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberProfileDto.getMemberId());
		ps.setString(2, memberProfileDto.getMemberProfileUploadname());
		ps.setString(3, memberProfileDto.getMemberProfileSavename());
		ps.setLong(4, memberProfileDto.getMemberProfileSize());
		ps.setString(5, memberProfileDto.getMemberProfileType());
		ps.execute();

		con.close();
	}
	
	public MemberProfileDto get(int memberProfileNo) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from member_profile where member_profile_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, memberProfileNo);
		ResultSet rs = ps.executeQuery();

		MemberProfileDto memberProfileDto;
		if(rs.next()) {
			memberProfileDto = new MemberProfileDto();
			memberProfileDto.setMemberProfileNo(rs.getInt("member_profile_no"));
			memberProfileDto.setMemberId(rs.getString("member_id"));
			memberProfileDto.setMemberProfileUploadname(rs.getString("member_profile_uploadname"));
			memberProfileDto.setMemberProfileSavename(rs.getString("member_profile_savename"));
			memberProfileDto.setMemberProfileSize(rs.getLong("member_profile_size"));
			memberProfileDto.setMemberProfileType(rs.getString("member_profile_type"));
		}
		else {
			memberProfileDto = null;
		}

		con.close();

		return memberProfileDto;
	}

	public MemberProfileDto get(String memberId) throws Exception {
		Connection con = JdbcUtils.connect2();

		String sql = "select * from member_profile where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();

		MemberProfileDto memberProfileDto;
		if(rs.next()) {
			memberProfileDto = new MemberProfileDto();
			memberProfileDto.setMemberProfileNo(rs.getInt("member_profile_no"));
			memberProfileDto.setMemberId(rs.getString("member_id"));
			memberProfileDto.setMemberProfileUploadname(rs.getString("member_profile_uploadname"));
			memberProfileDto.setMemberProfileSavename(rs.getString("member_profile_savename"));
			memberProfileDto.setMemberProfileSize(rs.getLong("member_profile_size"));
			memberProfileDto.setMemberProfileType(rs.getString("member_profile_type"));
		}
		else {
			memberProfileDto = null;
		}

		con.close();

		return memberProfileDto;
	}
}
