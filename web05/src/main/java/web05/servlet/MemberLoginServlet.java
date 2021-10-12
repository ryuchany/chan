package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

//로그인 
//= 아이디와 비밀번호를 입력받아 참/거짓 판별하는 기능
//= 회원정보를 입력받아 참/거짓 판별하는 기능
@WebServlet(urlPatterns = "/member/login.txt")
public class MemberLoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 아이디, 비밀번호 --> 회원정보
			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");

			//MemberDto memberDto = new MemberDto();
			//memberDto.setMemberId(req.getParameter("memberId"));
			//memberDto.setMemberPw(req.getParameter("memberPw"));

			//처리
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.get(memberId);

//			boolean login;
//			if(memberDto != null && memberDto.getMemberPw().equals(memberPw)) {
//				login = true;
//			}
//			else {
//				login = false;
//			}
			boolean login = memberDto != null && memberDto.getMemberPw().equals(memberPw);

			//출력
			resp.setCharacterEncoding("MS949");
			if(login) {
				resp.getWriter().println("로그인 성공");
			}
			else {
				resp.getWriter().println("일치하지 않는 정보");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
