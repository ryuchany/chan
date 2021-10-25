package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;



@WebServlet(urlPatterns = "/board/delete.txt")
public class BoardDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : 회원아이디(세션) + 게시글번호
//			String memberId = (String) req.getSession().getAttribute("ses");
			int boardNo= Integer.parseInt(req.getParameter("boardNo"));	

			// 처리 : 게시글삭제
			BoardDao boardDao = new BoardDao();
			boolean success = boardDao.delete(boardNo);

			// = 성공이라면 게시판 목록으로 이동
			if (success) {
				req.getSession().removeAttribute("boardNo");
				resp.sendRedirect("delete_success.jsp");
			}
			// = 실패라면 처리를 하지 않고 이전 페이지로 이동
			else {
				resp.sendRedirect("list.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
