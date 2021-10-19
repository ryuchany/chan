package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/member/edit.txt")
public class MemberEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : MemberDto
			//= 세션 : memberId
			//= 파라미터 : memberPw, memberNick, memberBirth, memberEmail, memberPhone
			req.setCharacterEncoding("UTF-8");
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId((String)req.getSession().getAttribute("ses"));//세션
			memberDto.setMemberPw(req.getParameter("memberPw"));//파라미터
			memberDto.setMemberNick(req.getParameter("memberNick"));//파라미터
			memberDto.setMemberBirth(req.getParameter("memberBirth"));//파라미터
			memberDto.setMemberEmail(req.getParameter("memberEmail"));//파라미터
			memberDto.setMemberPhone(req.getParameter("memberPhone"));//파라미터

			//처리
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.edit(memberDto);

			//출력
			if(success) {
				resp.sendRedirect("edit_success.jsp");
			}
			else {
				resp.sendRedirect("edit.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
