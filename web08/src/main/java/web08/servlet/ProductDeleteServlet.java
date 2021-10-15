package web08.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;

@WebServlet(urlPatterns = "/product/delete.txt")
public class ProductDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 상품 번호 - no(int)
			int no = Integer.parseInt(req.getParameter("no"));

			//처리 : ProductDao
			ProductDao productDao = new ProductDao();
			boolean success = productDao.delete(no);

			//출력 : 성공 실패에 따라 각각 redirect 처리
			if(success) {
				resp.sendRedirect("delete_success.html");
				//resp.sendRedirect("/web08/product/delete_success.html");
			}
			else {
				resp.sendRedirect("delete_fail.html");
				//resp.sendRedirect("/web08/product/delete_fail.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
