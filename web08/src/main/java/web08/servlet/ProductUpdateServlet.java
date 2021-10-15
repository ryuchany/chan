package web08.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;
import web08.beans.ProductDto;

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

			//처리 : ProductDao
			ProductDao productDao = new ProductDao();
			boolean success = productDao.update(productDto);

			//출력 : 성공 실패에 따라 각각의 페이지로 redirect
			if(success) {
				resp.sendRedirect("update_success.html");
				//resp.sendRedirect("/web08/product/update_success.html");
			}
			else {
				resp.sendRedirect("update_fail.html");
				//resp.sendRedirect("/web08/product/update_fail.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
