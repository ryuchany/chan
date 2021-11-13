package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns = "/board/reply/edit.txt")
public class BoardReplyEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ReplyDto(replyNo + replyContent + boardNo)
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReplyNo(Integer.parseInt(req.getParameter("replyNo")));
			replyDto.setReplyContent(req.getParameter("replyContent"));
			replyDto.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));

			//처리 : 수정 ( + 댓글 수 갱신 불필요)
			ReplyDao replyDao = new ReplyDao();
			boolean success = replyDao.edit(replyDto);

			//출력 : 게시글 상세페이지 redirect
			if(success) {
				resp.sendRedirect("../detail.jsp?boardNo="+replyDto.getBoardNo());
				//resp.sendRedirect(req.getContextPath()+"/board/detail.jsp?boardNo="+replyDto.getBoardNo());
			}
			else {
				resp.sendError(404);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}