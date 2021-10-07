package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test07 {
	public static void main(String[] args) throws Exception {
		// 입력
		MemberDto memberDto = new MemberDto();

		memberDto.setMemberId("testuser2");
		memberDto.setMemberPw("testuser1234");

		memberDto.setMemberNick("변경닉네임2");
		memberDto.setMemberBirth("2020-01-01");
		memberDto.setMemberEmail("testuser2@kh.com");
		memberDto.setMemberPhone("010-2222-2222");

		// 처리
		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.edit(memberDto);

		// 출력
		if (success) {
			System.out.println("정보 변경이 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 회원 정보입니다");
		}

	}
}