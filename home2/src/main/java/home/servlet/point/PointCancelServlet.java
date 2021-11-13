package home.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.CancelDao;
import home.beans.HistoryDao;
import home.beans.HistoryDto;
import home.beans.MemberDao;

@WebServlet(urlPatterns = "/point/cancel.txt")
public class PointCancelServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : historyNo
			int historyNo = Integer.parseInt(req.getParameter("historyNo"));

			//처리
			CancelDao cancelDao = new CancelDao();
			if(cancelDao.available(historyNo)) {//취소가 가능하다면
				cancelDao.insert(historyNo);//취소

				//회원 포인트도 차감(historyNo ---> historyAmount ---> 차감)
				HistoryDao historyDao = new HistoryDao();
				HistoryDto historyDto = historyDao.get(historyNo);

				MemberDao memberDao = new MemberDao();
				memberDao.addPoint(historyDto.getMemberId(), -historyDto.getHistoryAmount());
				//memberDao.removePoint(historyDto.getMemberId(), historyDto.getHistoryAmount());
				//memberDao.refreshPoint(historyDto.getMemberId());

				//성공페이지로 이동
				resp.sendRedirect("cancel_success.jsp");
			}
			else {//취소가 불가능하다면(이미 취소된 내역이라면)
				//오류페이지로 이동
				resp.sendRedirect("cancel_fail.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
