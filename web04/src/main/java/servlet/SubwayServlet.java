package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/subway.txt")
public class SubwayServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int birth = Integer.parseInt(req.getParameter("birth"));

		// 처리
		int age = 2021 - birth + 1;

		resp.getWriter().println("age = " + age);

		if (age >= 20 && age < 65) {
			resp.getWriter().println("price = " + 1250);

		} else if (age >= 14 && age < 20) {
			resp.getWriter().println("price = " + 720);

		} else if (age >= 8 && age < 14) {
			resp.getWriter().println("price = " + 450);

		} else {
			resp.getWriter().println("price = " + 0);
		}

	}
}
