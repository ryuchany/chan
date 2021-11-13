package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/admin/member/edit.txt")
public class AdminMemberEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : MemberDto(7개 항목)
			//req.setCharacterEncoding("UTF-8");//EncodingFilter 에서 처리됨
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));
			memberDto.setMemberPoint(Integer.parseInt(req.getParameter("memberPoint")));
			memberDto.setMemberGrade(req.getParameter("memberGrade"));

			//처리
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.editByAdmin(memberDto);

			//출력
			resp.sendRedirect("list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
