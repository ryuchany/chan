package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10_2 {
	public static void main(String[] args) {

		//입력
		List<Member> db = new ArrayList<>();
		//db.add("student", "student1234", "수강생");
		db.add(new Member("student", "student1234", "수강생"));
		db.add(new Member("teacher", "teacher1234", "강사"));
		db.add(new Member("master", "master1234", "관리자"));

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.next();
		sc.close();

		
		//List의 기능을 활용하여 로그인 판정을 수행(equals, hashCode를 재정의해야함)
		Member user = new Member(id, password);

		//db에 user와 동등한 데이터가 있다면(아이디,비밀번호)
		if(db.contains(user)) {
			System.out.println("[?]님 환영합니다!");
		}
		else {
			System.out.println("정보가 일치하지 않습니다");
		}
	}
}
