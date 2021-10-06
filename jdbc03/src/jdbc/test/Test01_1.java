package jdbc.test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test01_1 {
	public static void main(String[] args) throws Exception {
		// ExamDto를 준비하여 데이터를 미리 포장한 뒤 등록하도록 처리

		ExamDto examDto = new ExamDto();// 비어있는 객체 생성
		examDto.setStudent("거북왕");// 이름 담고
		examDto.setSubject("데이터입출력구현");// 과목 담고
		examDto.setType("서술형");// 유형 담고
		examDto.setScore(80);// 점수 담고

		// 1. 모듈 객체 생성
		ExamDao examDao = new ExamDao();

		// 2. 등록 메소드 호출
		// examDao.insert("거북왕", "데이터입출력구현", "서술형", 80);//데이터를 낱개로 관리
		examDao.insert(examDto);// 데이터를 의미있는 단위로 관리
		System.out.println("끝!");
	}
}
