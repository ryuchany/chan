package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/plus.txt")
public class PlusServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		int a = Integer.parseInt(arg0.getParameter("a"));
		int b = Integer.parseInt(arg0.getParameter("b"));
		
		int total = a+b;
		arg1.getWriter().println(total);
	}

}
