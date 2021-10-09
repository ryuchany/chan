package jdbc.Test;

import java.util.List;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test05 {
	public static void main(String[] args) throws Exception{
		
		String student = "아보크";
		
		ExamDao examDao = new ExamDao();
		List<ExamDto> list = examDao.selectByStudent(student);
		
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
