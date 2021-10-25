package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;


@WebServlet(urlPatterns = "/board/write.txt")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : BoardDto
			
			String boardWriter = (String)req.getSession().getAttribute("ses");
			
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardWriter(boardWriter);
			boardDto.setBoardTitle(req.getParameter("boardTitle"));
			boardDto.setBoardContent(req.getParameter("boardContent"));

			//처리
			BoardDao boardDao = new BoardDao();
			boardDao.write(boardDto);

			req.getSession().setAttribute("boardNo", boardDto.getBoardNo());
			//출력 : list.jsp
			resp.sendRedirect("list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
