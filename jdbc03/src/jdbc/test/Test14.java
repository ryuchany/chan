package jdbc.test;

import java.util.List;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test14 {
	public static void main(String[] args) throws Exception {

		MemberDao memberDao = new MemberDao();
		List<MemberDto> memberList = memberDao.list();

		for (MemberDto memberDto : memberList) {
			System.out.println(memberDto.getMemberId());
		}

	}
}
