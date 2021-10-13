package web07.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web07.beans.ExamDao;
import web07.beans.ExamDto;

@WebServlet(urlPatterns = "/update.txt")
public class ExamUpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 ExamDto(examId + student + subject + type + score)
			ExamDto examDto = new ExamDto();
			examDto.setExamId(Integer.parseInt(req.getParameter("examID")));
			examDto.setStudent(req.getParameter("student"));
			examDto.setSubject(req.getParameter("subject"));
			examDto.setType(req.getParameter("type"));
			examDto.setScore(Integer.parseInt(req.getParameter("score")));
			
			//처리
			ExamDao examDao = new ExamDao();
			boolean success = examDao.update(examDto);
			
			//출력 : 성공/실패 여부에 따라 다른 페이지로 리다이렉트
			if(success) {
				resp.sendRedirect("update_success.html");
			}else {
				resp.sendRedirect("update_fail.html");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
