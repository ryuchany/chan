package web03;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dice.txt")
public class DiceServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Random r = new Random();

		int number = r.nextInt(6) + 1;	

		resp.setCharacterEncoding("MS949");
		resp.getWriter().println("주사위 : " +number);
	}
}
