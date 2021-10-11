package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;
import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/insert.txt")
public class ProductInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ProductDto productDto = new ProductDto();
			productDto.setNo(Integer.parseInt(req.getParameter("no")));
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));

			ProductDao productDao = new ProductDao();
			productDao.insert(productDto);

			// 출력
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("제품 등록 완료");

		} catch (Exception e) {
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("처리 오류 발생");
			e.printStackTrace();
		}
	}
}
