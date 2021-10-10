package web03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿(Servlet)
//사용자가 주문할 수 있는 프로그래밍 코드를 보관한 클래스

//생성과정
//1. 적합한 부모 클래스를 찾아서 상속받는다(HttpServlet). - 자격 획득
//2. 주문 가능하도록 주소를 설정
//3. 이 파일(페이지)을 주문하면 만들어질 내용을 코드로 작성
//	   - 부모 클래스의 service()를 재정의하여 작성한다!
@WebServlet(urlPatterns = "/welcome.txt")//2
public class WelcomeServlet extends HttpServlet {//1
	@Override//3
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("hello Servlet");//결과를 서버의 콘솔에 출력
		resp.getWriter().println("Hello Servlet");//결과를 사용자가 볼 화면에 출력
	}
}
