package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test03 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		MemberDto memberDto = new MemberDto();

		System.out.print("아이디를 입력하세요 : ");
		memberDto.setMemberId(sc.nextLine());

		System.out.print("비밀번호를 입력하세요 : ");
		memberDto.setMemberPw(sc.nextLine());

		System.out.print("닉네임을 입력하세요 : ");
		memberDto.setMemberNick(sc.nextLine());

		System.out.print("생년월일을 입력하세요 : ");
		memberDto.setMemberBrith(sc.nextLine());

		System.out.print("이메일을 입력하세요 : ");
		memberDto.setMemberEmail(sc.nextLine());
		
		System.out.print("전화번호를 입력하세요 : ");
		memberDto.setMemberPhone(sc.nextLine());

		MemberDao memberDao = new MemberDao();
		memberDao.join(memberDto);

		System.out.println("회원 가입 완료");

		sc.close();

	}
}
