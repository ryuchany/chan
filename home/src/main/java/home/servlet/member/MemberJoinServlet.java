package home.servlet.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.MemberDao;
import home.beans.MemberDto;
import home.beans.MemberProfileDao;
import home.beans.MemberProfileDto;

//회원 가입 처리 서블릿
//= 입력창의 전송형태에 따라 메소드를 선택할 수 있다.
//= service()는 모든 방식을 수용하는 메소드
//= doGet()은 GET 방식만 수용하는 메소드
//= doPost()는 POST 방식만 수용하는 메소드
@WebServlet(urlPatterns = "/member/join.txt")
public class MemberJoinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//MultiPart 요청 처리 준비
			String savePath = "C:/upload";
			int maxSize = 5 * 1024 * 1024;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequest = 
						new MultipartRequest(req, savePath, maxSize, encoding, policy);
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(mRequest.getParameter("memberId"));
			memberDto.setMemberPw(mRequest.getParameter("memberPw"));
			memberDto.setMemberNick(mRequest.getParameter("memberNick"));
			memberDto.setMemberBirth(mRequest.getParameter("memberBirth"));
			memberDto.setMemberEmail(mRequest.getParameter("memberEmail"));
			memberDto.setMemberPhone(mRequest.getParameter("memberPhone"));

			//처리 : MemberDao
			MemberDao memberDao = new MemberDao();
			memberDao.join(memberDto);
			
			//프로필이 있다면 등록 처리
			if(mRequest.getFile("attach") != null) {//파일이 attach란 이름으로 올라왔다면
				MemberProfileDto memberProfileDto = new MemberProfileDto();
				memberProfileDto.setMemberId(memberDto.getMemberId());//회원 아이디
				memberProfileDto.setMemberProfileSavename(mRequest.getFilesystemName("attach"));//실제저장된이름
				memberProfileDto.setMemberProfileUploadname(mRequest.getOriginalFileName("attach"));//사용자가올린이름
				memberProfileDto.setMemberProfileType(mRequest.getContentType("attach"));//파일 유형
				memberProfileDto.setMemberProfileSize(mRequest.getFile("attach").length());

				MemberProfileDao memberProfileDao = new MemberProfileDao();
				memberProfileDao.insert(memberProfileDto);
			}
			
			//출력 : 리다이렉트
			resp.sendRedirect("join_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);//사용자에게 500번 상태값을 전송(500은 Internal server error)
		}
	}
}
