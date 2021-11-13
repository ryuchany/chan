package home.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.CoinDao;
import home.beans.CoinDto;
import home.beans.HistoryDao;
import home.beans.HistoryDto;
import home.beans.MemberDao;

@WebServlet(urlPatterns = "/point/charge.txt")
public class PointChargeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			/**
			 	포인트 충전 프로세스
				1. 충전할 포인트 상품의 번호를 수신(파라미터)
				2. 충전할 회원의 아이디를 수신(세션)
				3. 충전할 포인트 상품의 금액 정보를 조회(단일조회)
				4. 회원번호와 금액정보를 이용하여 내역을 추가(등록)
				5. 회원 포인트 정보를 수정
			 */

			//1
			int coinNo = Integer.parseInt(req.getParameter("coinNo"));

			//2
			String memberId = (String)req.getSession().getAttribute("ses");

			//3 - coin 단일조회
			CoinDao coinDao = new CoinDao();
			CoinDto coinDto = coinDao.get(coinNo);

			//4 - history 등록
			HistoryDto historyDto = new HistoryDto();
			historyDto.setMemberId(memberId);
			historyDto.setHistoryAmount(coinDto.getCoinAmount());
			historyDto.setHistoryMemo("포인트상품 구매");

			HistoryDao historyDao = new HistoryDao();
			historyDao.insert(historyDto);

			//5 - member 수정
			//[1] 원래 포인트에서 현재 포인트만 추가 - 회원아이디, 추가된 포인트
			//[2] history에서 해당 회원 내역을 전부 계산하여 재설정 - 회원아이디
			MemberDao memberDao = new MemberDao();
			memberDao.addPoint(memberId, coinDto.getCoinAmount());//1번 방식
			//memberDao.refreshPoint(memberId);//2번 방식

			//완료 시 redirect
			resp.sendRedirect("charge_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
