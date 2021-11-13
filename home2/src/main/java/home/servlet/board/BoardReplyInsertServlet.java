package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns = "/board/reply/insert.txt")
public class BoardReplyInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ReplyDto(파라미터 : boardNo + replyContent , 세션 : replyWriter)
			ReplyDto replyDto = new ReplyDto();
			replyDto.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));
			replyDto.setReplyContent(req.getParameter("replyContent"));

			replyDto.setReplyWriter((String)req.getSession().getAttribute("ses"));

			//처리
			//1. 댓글 등록
			//2. 게시글의 댓글 수 조정
			ReplyDao replyDao = new ReplyDao();
			replyDao.insert(replyDto);

			BoardDao boardDao = new BoardDao();
			boolean success = boardDao.refreshReplyCount(replyDto.getBoardNo());

			//출력
			resp.sendRedirect("../detail.jsp?boardNo="+replyDto.getBoardNo());
			//resp.sendRedirect(req.getContextPath()+"/board/detail.jsp?boardNo="+replyDto.getBoardNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
