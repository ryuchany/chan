package jdbc.test;

import jdbc.beans.ExamDao;

public class Test09 {
	public static void main(String[] args) throws Exception {
		// exam 데이터 삭제 예제

		//입력
		int examId = 5;
		
		//처리
		ExamDao examDao = new ExamDao();
		boolean success = examDao.delete(examId);
		
		//출력
		if(success) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 시험지 번호");
		}
	}
}
