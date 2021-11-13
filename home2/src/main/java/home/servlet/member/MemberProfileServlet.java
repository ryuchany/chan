package home.servlet.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberProfileDao;
import home.beans.MemberProfileDto;

@WebServlet(urlPatterns = "/member/profile.txt")
public class MemberProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			int memberProfileNo = Integer.parseInt(req.getParameter("memberProfileNo"));

			//처리
			MemberProfileDao memberProfileDao = new MemberProfileDao();
			MemberProfileDto memberProfileDto = memberProfileDao.get(memberProfileNo);

			File dir = new File("C:/upload/member");
			File target = new File(dir, memberProfileDto.getMemberProfileSavename());
			InputStream in = new FileInputStream(target);
			byte[] buffer = new byte[8192];

			String encodeFilename = URLEncoder.encode(memberProfileDto.getMemberProfileUploadname(), "UTF-8");
			encodeFilename = encodeFilename.replace("+", "%20");

			resp.setHeader("Content-Type", "application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename=\""+encodeFilename+"\"");
			resp.setHeader("Content-Encoding", "UTF-8");
			resp.setHeader("Content-Length", String.valueOf(memberProfileDto.getMemberProfileSize()));

			while(true) {
				int size = in.read(buffer);
				if(size == -1) break;
				resp.getOutputStream().write(buffer, 0, size);
			}

			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
