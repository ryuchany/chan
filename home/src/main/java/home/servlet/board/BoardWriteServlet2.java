package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

//파일 업로드가 
@WebServlet(urlPatterns = "/board/write2.txt")
public class BoardWriteServlet2 extends HttpServlet{
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
			
			//새글인지 답글인지 판정 : 파라미터에 boardSuperno가 있으면 답글이다
			boolean answer = req.getParameter("boardSuperno") != null;
			//답글일 경우에는 boardSuperno를 저장한다.
			if(answer) {
				boardDto.setBoardSuperno(Integer.parseInt(req.getParameter("boardSuperno")));
			}

			//처리
			//(1) 일반적인 등록
			//BoardDao boardDao = new BoardDao();
			//boardDao.write(boardDto);

			//(2) 번호를 알아내면서 등록
			BoardDao boardDao = new BoardDao();
			int boardNo = boardDao.getSequence();//시퀀스 번호 생성
			boardDto.setBoardNo(boardNo);//게시글 데이터에 생성된 번호 추가
			//답글일 경우 등록될 글의 정보를 상위글 정보를 기준으로 계산해야 한다.
			if(answer) {
				//1. 상위글의 모든 정보를 불러온다
				BoardDto parentDto = boardDao.get(boardDto.getBoardSuperno());
				//2. 상위글의 정보를 토대로 등록될 글의 정보를 계산한다
				//= 그룹은 동일하게 유지하고 차수는 1 증가시켜서 설정한다
				boardDto.setBoardGroupno(parentDto.getBoardGroupno());
				boardDto.setBoardDepth(parentDto.getBoardDepth() + 1);
				boardDao.writeAnswer(boardDto);//게시글 등록(답글)
			}else{
				boardDao.write2(boardDto);//게시글 등록(새글)
			}

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
