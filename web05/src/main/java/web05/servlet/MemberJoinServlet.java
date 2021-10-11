package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/join.txt")
public class MemberJoinServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberDto memberDto = new MemberDto();
	
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));

			MemberDao memberDao = new MemberDao();
			memberDao.join(memberDto);

			// 출력
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("회원 정보 등록 완료");

		} catch (Exception e) {
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("처리 오류 발생");
			e.printStackTrace();
		}
	}
}
