package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/detail.txt")
public class ProductDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			int no = Integer.parseInt(req.getParameter("no"));
			
			//처리
			ProductDao productDao = new ProductDao();
			ProductDto productDto = productDao.get(no);
			
			//출력
			resp.setCharacterEncoding("MS949");
			if(productDto == null) {
				resp.getWriter().println("찾으시는 번호의 제품정보가 없습니다");
			}
			else {
				resp.getWriter().println("제품정보 : " + productDto.getNo());
				resp.getWriter().println("제품이름 : " + productDto.getName());
				resp.getWriter().println("제품종류 : " + productDto.getType());
				resp.getWriter().println("제품가격 : " + productDto.getPrice());
				resp.getWriter().println("제조일 : " + productDto.getMade());
				resp.getWriter().println("유통기한 : " + productDto.getExpire());
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
