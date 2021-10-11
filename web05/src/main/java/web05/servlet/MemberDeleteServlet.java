package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;

@WebServlet(urlPatterns = "/member/delete.txt")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberId = req.getParameter("memberId");

			MemberDao memberDao = new MemberDao();
			boolean seccess = memberDao.delete(memberId);

			resp.setCharacterEncoding("MS949");
			if (seccess) {
				resp.getWriter().println("회원 정보가 삭제 성공");
			} else {
				resp.getWriter().println("존재하지 않는 회원 아이디");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
