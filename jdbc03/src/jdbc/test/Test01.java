package jdbc.test;

import jdbc.beans.ExamDao;

public class Test01 {
	public static void main(String[] args) throws Exception {
		// ExamDao 모듈을 이용하여 exam 테이블에 데이터를 insert 하도록 코드 구현

		// 1. 모듈 객체 생성
		ExamDao examDao = new ExamDao();

		// 2. 등록 메소드 호출
		examDao.insert("거북왕", "데이터입출력구현", "서술형", 80);
		System.out.println("끝!");
	}
}
