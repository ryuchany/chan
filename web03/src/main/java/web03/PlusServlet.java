package web03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/plus.txt")
public class PlusServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 입력 - 스캐너 사용 금지
		// = 웹 페이지에서의 입력은 "주소"를 통해서 파라미터로 전달된다.
		// = 주소에 ?가 있다면 그 뒷부분을 파라미터라고 보면 된다.
		// = 사용자가 보낸 정보(요청정보)를 가진 객체인 req에서 파라미터를 추출하도록 지시
		// = req.getParameter("a") 는 파라미터 중 a와 연결된 데이터를 가져오라는 뜻(없으면 null)
		// = 모든 파라미터는 무조건 String으로만 읽힌다.
		// = 숫자로 바꾸고 싶다면 변환명령을 추가로 작성해야 한다.
		// = ex) 주소뒤에 /plus.txt?a=10&b=20
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b")); 
		
		// 계산
		int total = a + b;

		// 출력
		resp.getWriter().println("total = " + total);

	}
}
