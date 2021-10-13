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

@WebServlet(urlPatterns = "/search.txt")
public class ExamSearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : column, keyword
			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");
			
			//처리 : column, keyword 둘 다 있는 경우만 검색을 처리
			//if(column이나 keyword중 하나라도 없으면) {
			if(column==null || keyword==null || column.equals(" ") || keyword.equals(" ")) {
				throw new Exception();
			}
			
			ExamDao examDao = new ExamDao();
			List<ExamDto> list =examDao.select(column, keyword);
			
			//출력 : 리다이렉트? 불가. 데이터전달이 안됨
			//resp.sendRedirect("search.result.html");
			
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("검색결과 : "+list.size()+"개");
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
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}

	}
}
