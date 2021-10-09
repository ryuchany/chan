package jdbc.Test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

import java.util.List;

public class Test06 {
	public static void main(String[] args) throws Exception {

		String column = "student";
		String keyword = "아보크";
		
		ExamDao examDao = new ExamDao();
		List<ExamDto> list = examDao.select(column, keyword);
		
		// 출력
		System.out.println("개수 : " + list.size());
		for (ExamDto examDto : list) {
			System.out.println(examDto);
		}
		
	}
}
