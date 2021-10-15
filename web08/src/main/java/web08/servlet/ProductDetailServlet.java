package web08.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;
import web08.beans.ProductDto;

@WebServlet(urlPatterns = "/product/detail.txt")
public class ProductDetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 상품번호(int no)
			int no = Integer.parseInt(req.getParameter("no"));

			//처리 : ProductDao
			ProductDao productDao = new ProductDao();
			ProductDto productDto = productDao.get(no);

			//출력 : 리다이렉트 불가. 직접 출력.
			resp.setCharacterEncoding("MS949");
			if(productDto != null) {
				resp.getWriter().println("+-------------------------------+");
				resp.getWriter().println("| 번호 : " + productDto.getNo() + "");
				resp.getWriter().println("| 이름 : " + productDto.getName() + "");
				resp.getWriter().println("| 구분 : " + productDto.getType() + "");
				resp.getWriter().println("| 가격 : " + productDto.getPrice() + "원");
				resp.getWriter().println("| 제조일 : " + productDto.getMade().substring(0, 10) + "");
				resp.getWriter().println("| 폐기일 : " + productDto.getExpire().substring(0, 10) + "");
				resp.getWriter().println("+-------------------------------+");
				resp.getWriter().println();
			}
			else {
				resp.getWriter().println("존재하지 않는 상품번호");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
