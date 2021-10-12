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

//파라미터 여부에 따라 목록 또는 검색을 수행하는 서블릿 구현
@WebServlet(urlPatterns = "/exam/find.txt")
public class ExamFindServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");

			//처리
			boolean searchMode = column != null && !column.equals(" ") 
															&& keyword != null && !keyword.equals(" ");

			ExamDao examDao = new ExamDao();

			List<ExamDto> list;
			if(searchMode) {//검색
				list = examDao.select(column, keyword);
			}
			else {//목록
				list = examDao.select();
			}

			//출력
			resp.setCharacterEncoding("MS949");
			for(ExamDto examDto : list) {
				resp.getWriter().println(examDto.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
