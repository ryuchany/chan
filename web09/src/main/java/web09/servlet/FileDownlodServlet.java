package web09.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download.txt")
//목표 : C:/upload(또는 다른 경로) 에 있는 test.txt라는 파일을 접속 시 바로 다운로드 하도록 페이지 구성
public class FileDownlodServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//구조 : [test.txt] ---(입력)---> [서블릿] ---(출력)---> [사용자]
		//준비물 :
		//1. test.txt에 대한 파일 객체
		//2. test.txt에 대한 입력 스트림(FileInputStream)
		//3. 읽은 내용을 사용자에게 전달하기 위한 도구(resp)
		
		File target = new File("c:/upload", "test.txt");
		FileInputStream in = new FileInputStream(target);
		byte[] buffer = new byte[1024]; //1024배수 기준
		
		//[주의] 서버는 사용자에게 지금부터 보내는 내용이 "다운로드"를 위한 것임을 알려줘야 할 의무가 있다. 
		//= 추가적으로 "헤더" 설정을 해줘야 한다.
		//= 헤더는 사용자가 받게 될 내용에 대한 정보
		//= 보낼 내용의 유형, 크기, 이름, 방식, 설명, ...
		//= resp.setHeader("이름", "값"); 형태로 설정한다.
		//= header는 String밖에 설정할 수 없다.
		
		resp.setHeader("Content-Type", "application/octet-stream");
		//resp.setContentType("application/octet-stream");

		resp.setHeader("Content-Disposition", "attachment; filename=test.txt");

		resp.setHeader("Content-Encoding", "UTF-8");

		resp.setHeader("Content-Length", String.valueOf(target.length()));
		//resp.setContentLength((int)target.length());

		while(true) {
			int size = in.read(buffer);//size개 만큼 읽어오는 코드
			if(size == -1) break;
			resp.getOutputStream().write(buffer, 0, size);//size개만큼 내보내는 코드
		}

		in.close();
	}
}
