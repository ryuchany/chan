package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test22 {
	public static void main(String[] args) throws Exception {
		//모듈화가 완료되었을때의 장점
		//ex : 회원 가입 시 아이디 중복 검사

		//-> 아이디를 먼저 입력받아서 사용이 가능한지 확인 후 나머지 정보를 입력받겠다
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String memberId = sc.nextLine();

		//아이디검사
		if(memberDao.get(memberId) != null) {//memberId의 단일조회 결과가 있으면(not null) = 아이디가 이미 존재한다면
			System.out.println("이미 사용중인 아이디입니다");
			System.exit(0);
		}

		memberDto.setMemberId(memberId);

		System.out.print("비밀번호 : ");
		memberDto.setMemberPw(sc.nextLine());

		System.out.print("닉네임 : ");
		memberDto.setMemberNick(sc.nextLine());

		System.out.print("생년월일 : ");
		memberDto.setMemberBirth(sc.nextLine());

		System.out.print("이메일 : ");
		memberDto.setMemberEmail(sc.nextLine());

		System.out.print("전화번호 : ");
		memberDto.setMemberPhone(sc.nextLine());

		sc.close();

		//가입
		memberDao.join(memberDto);
		System.out.println("가입이 완료되었습니다");

	}
}
