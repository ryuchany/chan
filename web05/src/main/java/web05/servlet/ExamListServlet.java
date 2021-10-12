package web05.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;
import web05.beans.ExamDto;

@WebServlet(urlPatterns = "/exam/list.txt")
public class ExamListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : 없음

			// 처리
			ExamDao examDao = new ExamDao();
			List<ExamDto> list = examDao.select();

			// 출력
			resp.setCharacterEncoding("MS949");
			for (ExamDto examDto : list) {
				resp.getWriter().println(examDto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Error");
		}
	}
}
