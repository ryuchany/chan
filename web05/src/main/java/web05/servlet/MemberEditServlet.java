package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/edit.txt")
public class MemberEditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : MemberDto
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));

			//처리
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.edit(memberDto);

			//출력
			resp.setCharacterEncoding("MS949");
			if(success) {
				resp.getWriter().println("회원 정보 변경 성공");
			}
			else {
				resp.getWriter().println("존재하지 않는 회원 아이디");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
