package web09.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/multi.txt")
public class MultipleParameterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//다음 형태의 파라미터 수신
			//surveyTitle=a&surveyContent=b&surveyContent=c&surveyContent=d&surveyContent=e

			//-> surveyTitle은 기존 방식처럼 받으면 된다(파라미터 1개 고정) ---> String
			//-> surveyContent는 데이터 개수를 확정할 수 없다(파라미터 여러개) ---> String[]
			String surveyTitle = req.getParameter("surveyTitle");
			String[] surveyContent = req.getParameterValues("surveyContent");

			System.out.println("surveyTitle = " + surveyTitle);
			System.out.println("surveyContent = " + Arrays.toString(surveyContent));
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}