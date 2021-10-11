package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/update.txt")
public class ProductUpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ProductDto(no, name, type, price, made, expire)
			ProductDto productDto = new ProductDto();
			productDto.setNo(Integer.parseInt(req.getParameter("no")));
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));

			//처리
			ProductDao productDao = new ProductDao();
			boolean success = productDao.update(productDto);

			//출력
			resp.setCharacterEncoding("MS949");
			if(success) {
				resp.getWriter().println("상품 정보 변경 성공");
			}
			else {
				resp.getWriter().println("존재하지 않는 상품 번호");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
