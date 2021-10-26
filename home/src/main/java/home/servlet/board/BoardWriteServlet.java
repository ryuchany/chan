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
			//입력 : BoardDto(boardTitle, boardContent)
			//req.setCharacterEncoding("UTF-8");//EncodingFilter에서 처리
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardTitle(req.getParameter("boardTitle"));
			boardDto.setBoardContent(req.getParameter("boardContent"));

			//아이디는 세션에서 수집하여 추가
			boardDto.setBoardWriter((String)req.getSession().getAttribute("ses"));

			//처리
			//(1) 일반적인 등록
			//BoardDao boardDao = new BoardDao();
			//boardDao.write(boardDto);

			//(2) 번호를 알아내면서 등록
			BoardDao boardDao = new BoardDao();
			int boardNo = boardDao.getSequence();//시퀀스 번호 생성
			boardDto.setBoardNo(boardNo);//게시글 데이터에 생성된 번호 추가
			boardDao.write2(boardDto);//게시글 등록

			//출력
			//(1) list.jsp로 리다이렉트
			//resp.sendRedirect("list.jsp");

			//(2) detail.jsp로 리다이렉트
			resp.sendRedirect("detail.jsp?boardNo="+boardNo);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
