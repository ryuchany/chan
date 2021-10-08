package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/total.txt")
public class TotalServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int begin = Integer.parseInt(req.getParameter("begin"));
		int end = Integer.parseInt(req.getParameter("end"));

		int total = 0;
		for (int i = begin; i <= end; i++) {
			total += i;
			
		}
		resp.getWriter().print(" total = " + total);
	}
}
