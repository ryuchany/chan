package jdbc.Test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test02 {
	public static void main(String[] args) throws Exception {

		ExamDto examDto = new ExamDto();
		examDto.setExamId(81);
		examDto.setStudent("아보크");
		examDto.setSubject("c언어");
		examDto.setType("c언어");
		examDto.setScore(10);

		ExamDao examDao = new ExamDao();
		boolean isSuccess = examDao.update(examDto);

		if (isSuccess) {
			System.out.println("수정완료");
		} else {
			System.out.println("잘못된 번호입니다");
		}

	}
}
