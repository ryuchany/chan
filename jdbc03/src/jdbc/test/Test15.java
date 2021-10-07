package jdbc.test;

import java.util.List;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test15 {
	public static void main(String[] args) throws Exception {
		//학생명으로 시험정보 검색

		//입력 : 학생명(String)
		String student = "피카츄";

		//처리
		ExamDao examDao = new ExamDao();
		List<ExamDto> list = examDao.selectByStudent(student);

		//출력 : 목록때와 동일
		System.out.println("개수 : "+list.size());
		for(ExamDto examDto : list) {
			System.out.print(examDto.getExamId());
			System.out.print(" / ");
			System.out.print(examDto.getStudent());
			System.out.print(" / ");
			System.out.print(examDto.getSubject());
			System.out.print(" / ");
			System.out.print(examDto.getType());
			System.out.print(" / ");
			System.out.print(examDto.getScore());
			System.out.println();
		}
	}
}
