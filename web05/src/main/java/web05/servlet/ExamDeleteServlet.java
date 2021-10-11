package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;

@WebServlet(urlPatterns = "/exam/delete.txt")
public class ExamDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : Primary key(int examId)
			int examId = Integer.parseInt(req.getParameter("examId"));

			//처리
			ExamDao examDao = new ExamDao();
			boolean success = examDao.delete(examId);

			//출력
			resp.setCharacterEncoding("MS949");
			if(success) {
				resp.getWriter().println("시험 정보 삭제 성공");
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
