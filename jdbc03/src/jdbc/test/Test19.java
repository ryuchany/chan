package jdbc.test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test19 {
	public static void main(String[] args) throws Exception {
		//exam 단일조회

		//입력 : 시험지번호
		int examId = 3;

		//처리
		ExamDao examDao = new ExamDao();
		ExamDto examDto = examDao.select(examId);

		//출력
		if(examDto == null) {
			System.out.println("해당 시험지는 존재하지 않습니다");
		}
		else{
			System.out.println(examDto);
		}
	}
}
