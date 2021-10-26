package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

//게시판 수정, 삭제 기능에 대한 본인확인 필터
@WebFilter(urlPatterns = {
		"/board/edit.jsp", "/board/edit.txt",
		"/board/delete.txt"
})
public class BoardSelfFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;

		/**
		 * 시나리오
		 * 1. 모든 요청에는 boardNo라는 파라미터가 존재한다(만약에 없으면 차단)
		 * 2. boardNo를 이용해서 해당 번호 게시글의 "작성자(boardWriter)"를 조회한다.
		 * 3. 세션을 조회하여 현재 로그인한 사용자의 ID를 알아낸다.
		 * 4. 2번과 3번에서 알아낸 정보를 비교한다.
		 * 5-1. 4번의 결과가 같다고 나올 경우 본인 글이므로 통과시킨다.
		 * 5-2. 4번의 결과가 다르다고 나올 경우 본인 글이 아니므로 차단시킨다.
		 */
		try {
			req.setCharacterEncoding("UTF-8");
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));

			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.get(boardNo);

			String memberId = (String)req.getSession().getAttribute("ses");

			if(boardDto == null) {//대상 게시글이 없으면(잘못된 번호)
				resp.sendError(404);//404 not found
			}
			else if(memberId == null) {//비회원이면
				resp.sendError(401);//401 unauthorized
			}
			else if(boardDto.getBoardWriter().equals(memberId)) {//아이디 일치(본인)
				chain.doFilter(request, response);//통과
			}
			else {
				resp.sendError(403);//403 forbidden
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
