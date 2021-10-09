package jdbc.Test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test03 {
	public static void main(String[] args) throws Exception {
		
		int examId = 82;
		
		ExamDao examDao = new ExamDao();
		boolean isSuccess = examDao.delete(examId);
		
		if(isSuccess) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("없음");
		}
		
	}
}
