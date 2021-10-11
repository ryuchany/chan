package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;
import web05.beans.ExamDto;

@WebServlet(urlPatterns = "/exam/update.txt")
public class ExamUpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ExamDto
			ExamDto examDto = new ExamDto();
			examDto.setExamId(Integer.parseInt(req.getParameter("examId")));
			examDto.setStudent(req.getParameter("student"));
			examDto.setSubject(req.getParameter("subject"));
			examDto.setType(req.getParameter("type"));
			examDto.setScore(Integer.parseInt(req.getParameter("score")));

			//처리
			ExamDao examDao = new ExamDao();
			boolean success = examDao.update(examDto);

			//출력
			resp.setCharacterEncoding("MS949");
			if(success) {
				resp.getWriter().println("시험 정보 변경 완료");
			}
			else {
				resp.getWriter().println("존재하지 않는 시험지 번호");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
