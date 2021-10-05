package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		// 저장소 생성
		Map<String, String> db = new HashMap<>();

		// 데이터 등록
		db.put("testuser", "testuser1234");
		db.put("student", "student1234");
		db.put("manager", "manager1234");

		// 사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();

		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.next();
		sc.close();

		// 판정
		// & 연산은 멍청한 연산 , && 연산은 똑똑한 연산
		// & 연산은 안봐도 되는 상황을 파악하지 못하고, && 연산은 안봐도 되는 상황을 파악하여 연산 수행
		// = 지금 상황이라면 아이디가 존재하지 않으면 비밀번호는 볼 필요가 없다
		// = && 를 사용하면 아이디가 존재하지 않을 경우 비밀번호 비교를 수행하지 않는다

		// boolean isLogin = 아이디 일치 && 비밀번호 일치;
		// boolean isLogin = db.containsKey(id) && db.containsValue(password);//아이디가
		// 존재하고 비밀번호도 존재합니까?
		boolean isLogin = db.containsKey(id) && db.get(id).equals(password);// 아이디가 존재하고 그 아이디에 해당하는 비밀번호와 일치합니까?

		if (isLogin) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
