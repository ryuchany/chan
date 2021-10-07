package jdbc.test;

import jdbc.beans.MemberDao;

public class Test11 {
	public static void main(String[] args) throws Exception {

		// 입력
		String memberId = "qwer1234";

		// 처리
		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.delete(memberId);

		// 출력
		if (success) {
			System.out.println("회원 탈퇴 처리가 완료되었습니다");
		} else {
			System.out.println("존재하지 않는 회원입니다");
		}

	}
}
