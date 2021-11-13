package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

//회원 가입 처리 서블릿(기존 방식)
//= 입력창의 전송형태에 따라 메소드를 선택할 수 있다.
//= service()는 모든 방식을 수용하는 메소드
//= doGet()은 GET 방식만 수용하는 메소드
//= doPost()는 POST 방식만 수용하는 메소드
@WebServlet(urlPatterns = "/member/join2.txt")
public class MemberJoinServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : MemberDto
			//= 문제점 : POST 방식으로 전송될 경우 유니코드가 ASCII코드로 변경되어 전송된다.
			//= 해결책 : 수신한 데이터를 원래의 인코딩방식으로 변환하도록 지시한다.
			//= 주의 : 반드시 수신 전에 복원명령을 작성해야 한다.
			req.setCharacterEncoding("UTF-8");
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));

			//처리 : MemberDao
			MemberDao memberDao = new MemberDao();
			memberDao.join(memberDto);

			//출력 : 리다이렉트
			resp.sendRedirect("join_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);//사용자에게 500번 상태값을 전송(500은 Internal server error)
		}
	}
}
