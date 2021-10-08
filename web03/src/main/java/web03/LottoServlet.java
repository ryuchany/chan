package web03;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lotto.txt")
public class LottoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Set<Integer> lotto = new TreeSet<>();

		Random r = new Random();

		for (int i = 0; i < 6; i++) {
			int number = r.nextInt(45) + 1;
			if (!lotto.contains(number)) {
				lotto.add(number);
			} else {
				i--;
			}
		}
		resp.setCharacterEncoding("MS949");
		resp.getWriter().println("로또 번호 : " +lotto);
	}
}
