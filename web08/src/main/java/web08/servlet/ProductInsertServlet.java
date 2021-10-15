package web08.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;
import web08.beans.ProductDto;

//상품 등록 처리 서블릿
@WebServlet(urlPatterns = "/product/insert.txt")
public class ProductInsertServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ProductDto(name, type, price, made, expire)
			ProductDto productDto = new ProductDto();
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));

			//처리
			ProductDao productDao = new ProductDao();
			productDao.insert(productDto);

			//출력 : 성공 페이지로 redirect
			resp.sendRedirect("insert_success.html");//상대경로
			//resp.sendRedirect("/web08/product/insert_success.html");//절대경로
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
