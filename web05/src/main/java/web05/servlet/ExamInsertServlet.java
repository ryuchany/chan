package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;
import web05.beans.ExamDto;

//이 서블릿은 exam 테이블에 데이터를 추가하는 기능을 가진 서블릿
//주소 : http://localhost:8080/web05/exam/insert.txt
//입력 : 
//출력 : 
@WebServlet(urlPatterns = "/exam/insert.txt")
public class ExamInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : ExamDto(student, subject, type, score)
			ExamDto examDto = new ExamDto();
			examDto.setStudent(req.getParameter("student"));
			examDto.setSubject(req.getParameter("subject"));
			examDto.setType(req.getParameter("type"));
			examDto.setScore(Integer.parseInt(req.getParameter("score")));

			// 처리 : 데이터베이스 테이블(exam) 추가 작업
			ExamDao examDao = new ExamDao();
			examDao.insert(examDto);

			// 출력
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("시험 정보 등록 완료");
			
		}
		catch (Exception e) {
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("처리 오류 발생");
			e.printStackTrace();
		}
	}
}
