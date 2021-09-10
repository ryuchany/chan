package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10_1 {
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
		
		//반복문을 통해서 직접 회원의 아이디와 비밀번호를 비교
		Member find = null;//찾은 회원이 없다고 가정
		for(Member m : db) {
//			if(아이디와 비밀번호가 모두 일치한다면) {
			if(m.getId().equals(id) && m.getPassword().equals(password)) {
				find = m;
				break;
			}
		}

//		System.out.println("find = " + find);
		if(find != null) {
			System.out.println("["+find.getNickname()+"]님 환영합니다");
		}
		else {
			System.out.println("정보가 일치하지 않습니다");
		}
	}
}
