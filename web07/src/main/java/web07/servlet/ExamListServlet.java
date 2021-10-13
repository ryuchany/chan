package web07.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web07.beans.ExamDao;
import web07.beans.ExamDto;

@WebServlet(urlPatterns = "/list.txt")
public class ExamListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 없음			
			//처리 : ExamDao
			ExamDao examDao = new ExamDao();
			List<ExamDto> list = examDao.select();
			
			//출력 : 리다이렉트 불가(화면으로 데이터 전달을 할 수 없음. HTML은 정적화면만 구현 가능)
			//resp.sendRedirect("결과페이지");//불가
			resp.setCharacterEncoding("MS949");
			for(ExamDto examDto : list) {
				resp.getWriter().print(examDto.getExamId());
				resp.getWriter().print(" / ");
				resp.getWriter().print(examDto.getStudent());
				resp.getWriter().print(" / ");
				resp.getWriter().print(examDto.getSubject());
				resp.getWriter().print(" / ");
				resp.getWriter().print(examDto.getType());
				resp.getWriter().print(" / ");
				resp.getWriter().print(examDto.getScore());
				resp.getWriter().print("점");
				resp.getWriter().println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
