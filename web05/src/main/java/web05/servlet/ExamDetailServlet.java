package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;
import web05.beans.ExamDto;

@WebServlet(urlPatterns = "/exam/detail.txt")
public class ExamDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			int examId = Integer.parseInt(req.getParameter("examId"));
			
			//처리
			ExamDao examDao = new ExamDao();
			ExamDto examDto = examDao.select(examId);
			
			//출력
			resp.setCharacterEncoding("MS949");
			if(examDto == null) {
				resp.getWriter().println("찾으시는 번호의 시험정보가 없습니다");
			}
			else {
				resp.getWriter().println("시험지정보 : " + examDto.getExamId());
				resp.getWriter().println("학생명 : " + examDto.getStudent());
				resp.getWriter().println("과목명 : " + examDto.getSubject());
				resp.getWriter().println("유형 : " + examDto.getType());
				resp.getWriter().println("점수 : " + examDto.getScore());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
