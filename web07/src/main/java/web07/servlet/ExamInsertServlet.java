package web07.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web07.beans.ExamDao;
import web07.beans.ExamDto;

@WebServlet(urlPatterns = "/insert.txt")
public class ExamInsertServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ExamDto(student + subject + type + score)
			ExamDto examDto = new ExamDto();
			examDto.setStudent(req.getParameter("student"));
			examDto.setSubject(req.getParameter("subject"));
			examDto.setType(req.getParameter("type"));
			examDto.setScore(Integer.parseInt(req.getParameter("score")));
			
			//처리
			ExamDao examDao = new ExamDao();
			examDao.insert(examDto);
			
			//출력 : 결과 페이지로 리다이렉트
			resp.sendRedirect("insert_success.html");
			
		}
		catch(Exception e){
			e.printStackTrace();
			resp.getWriter().println("error");
		}
		
	}
}
