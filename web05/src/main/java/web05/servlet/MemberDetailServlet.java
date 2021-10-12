package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;



@WebServlet(urlPatterns = "/member/detail.txt")
public class MemberDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			String memberId = req.getParameter("memberId");
			
			//처리
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.get(memberId);
			
			//출력
			resp.setCharacterEncoding("MS949");
			if(memberDto == null) {
				resp.getWriter().println("찾으시는 회원 정보가 없습니다");
			}
			else {
				resp.getWriter().println("회원아이디 : " + memberDto.getMemberId());
				resp.getWriter().println("회원닉네임 : " + memberDto.getMemberNick());
				resp.getWriter().println("회원생년월일 : " + memberDto.getMemberBirthDate());
				resp.getWriter().println("회원이메일 : " + memberDto.getMemberEmail());
				resp.getWriter().println("회원연락처 : " +memberDto.getMemberPhone());
				resp.getWriter().println("회원가입일 : " + memberDto.getMemberJoin());
				resp.getWriter().println("회원포인트 : " + memberDto.getMemberPoint());
				resp.getWriter().println("회원등급 : " + memberDto.getMemberGrade());
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
