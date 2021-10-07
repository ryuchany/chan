package jdbc.test;

import java.util.List;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test18 {
	public static void main(String[] args) throws Exception {

		String column = "member_id";
		String keyword = "asd";

		MemberDao memberDao = new MemberDao();
		List<MemberDto> memberList = memberDao.select(column, keyword);

		System.out.println("개수 : " + memberList.size());
		for (MemberDto memberDto : memberList) {
			System.out.print(memberDto.getMemberId());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberPw());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberNick());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberBirthDate());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberEmail());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberPhone());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberJoin());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberPoint());
			System.out.print(" / ");
			System.out.print(memberDto.getMemberGrade());
			System.out.println();
		}
	}
}
