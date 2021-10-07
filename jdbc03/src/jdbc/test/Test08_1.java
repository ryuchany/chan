package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test08_1 {
	public static void main(String[] args) throws Exception {

		// 입력 : 현재아이디, 현재비밀번호, 바꿀비밀번호
		// [1] String + String + String
		// [2] MemberDto + String

		// [1]
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId("testuser2");
		memberDto.setMemberPw("testuser1234");
		String changePw = "testuser2";

		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.editPassword(memberDto, changePw);

		if (success) {
			System.out.println("비밀번호 변경이 완료되었습니다");
		} else {
			System.out.println("정보가 일치하지 않습니다");
		}

	}
}