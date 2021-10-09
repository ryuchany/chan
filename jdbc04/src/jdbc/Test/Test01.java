package jdbc.Test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test01 {
	public static void main(String[] args) throws Exception {

		ExamDto examDto = new ExamDto();
		examDto.setStudent("피죤");
		examDto.setSubject("자바");
		examDto.setType("자바");
		examDto.setScore(100);
		
		ExamDao examDao = new ExamDao();
		examDao.insert(examDto);
		
		System.out.println("등록완료");
		
	}
}
