package web07.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web07.beans.ExamDao;

@WebServlet(urlPatterns = "/delete.txt")
public class ExamDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력
			int examId = Integer.parseInt(req.getParameter("examId"));

			// 처리
			ExamDao examDao = new ExamDao();
			boolean success = examDao.delete(examId);

			// 출력
			//= 화면을 서블릿에서 만들려고 애쓸 필요가 없다
			//= 화면은 HTML 등의 전문 페이지가 존재하기 때문에 해당 페이지로 사용자를 이동시키면 된다.
			//= 재접속 지시 코드 = 리다이렉트
			if(success) {
				resp.sendRedirect("delete_success.html");
			}
			else {
				resp.sendRedirect("delete_fail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
