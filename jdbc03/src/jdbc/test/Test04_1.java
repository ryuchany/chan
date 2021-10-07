package jdbc.test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test04_1 {
	public static void main(String[] args) throws Exception {
		//질문 답변 : 시험 정보 수정(이름만)

		//입력 : ExamDto
		ExamDto examDto = new ExamDto();
		examDto.setExamId(5);
		examDto.setStudent("포포링");

		//처리
		ExamDao examDao = new ExamDao();
		boolean isSuccess = examDao.updateStudent(examDto);

		//출력
		if(isSuccess) {
			System.out.println("변경이 완료되었습니다");
		}
		else {
			System.out.println("해당 번호의 정보가 없습니다");
		}
	}
}
