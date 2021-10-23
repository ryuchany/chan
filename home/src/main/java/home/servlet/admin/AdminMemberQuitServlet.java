package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/admin/member/quit.txt")
public class AdminMemberQuitServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 탈퇴시킬 회원의 아이디 - String memberId
			String memberId = req.getParameter("memberId");

			//처리 : 탈퇴 처리(D)
			MemberDao memberDao = new MemberDao();
			memberDao.quit(memberId);

			//출력 : 성공하든 실패하든 목록으로 redirect
			resp.sendRedirect("list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
