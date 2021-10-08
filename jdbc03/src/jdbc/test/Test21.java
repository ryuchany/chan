package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test21 {
	public static void main(String[] args) throws Exception {
		//회원 검색

		String memberId = "testuser2";

		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.get(memberId);

		if(memberDto != null) {
			System.out.println("[회원 정보]");
			System.out.println("아이디 : "+memberDto.getMemberId());
			System.out.println("닉네임 : "+memberDto.getMemberNick());
			System.out.println("생년월일 : "+memberDto.getMemberBirth());
			System.out.println("이메일 : "+memberDto.getMemberEmail());
			System.out.println("전화번호 : "+memberDto.getMemberPhone());
			System.out.println("가입일 : "+memberDto.getMemberJoin());
			System.out.println("포인트 : "+memberDto.getMemberPoint());
			System.out.println("등급 : "+memberDto.getMemberGrade());
		}
		else {
			System.out.println("해당 아이디의 회원은 존재하지 않습니다");
		}
	}
}
