package jdbc.Test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test07 {
	public static void main(String[] args) throws Exception {

		int examId = 81;

		ExamDao examDao = new ExamDao();
		ExamDto examDto = examDao.select(examId);

		// 출력
		if (examDto == null) {
			System.out.println("해당 시험지는 존재하지 않습니다");
		} else {
			System.out.println(examDto);
		}

	}
}
