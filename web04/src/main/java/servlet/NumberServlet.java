package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/number.txt")
public class NumberServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		int begin = Integer.parseInt(arg0.getParameter("begin"));
		int end = Integer.parseInt(arg0.getParameter("end"));

		int total = 0;
		for (int i = begin; i <= end; i++) {
			total += i;
			arg1.getWriter().println("i = " + i);
		}

		arg1.getWriter().println(total);

	}
}
