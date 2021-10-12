package web05.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDto;
import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/find.txt")
public class ProductFindServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");

			boolean search = column != null && !column.equals(" ") && keyword != null && !keyword.equals(" ");
			ProductDao productDao = new ProductDao();

			List<ProductDto> list;
			if (search) {// 검색
				list = productDao.select(column, keyword);
			} else {// 목록
				list = productDao.select();
			}
			
			resp.setCharacterEncoding("MS949");
			for(ProductDto productDto : list) {
				resp.getWriter().println(productDto.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
