package web08.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;
import web08.beans.ProductDto;

@WebServlet(urlPatterns = "/list.txt")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 
	
			//처리 : column, keyword 둘 다 있는 경우만 검색을 처리
			ProductDao productDao = new ProductDao();
			List<ProductDto> list = productDao.select();
				
			//출력 : 리다이렉트? 불가. 데이터전달이 안됨
			//resp.sendRedirect("search.result.html");
			
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("검색결과 : "+list.size()+"개");
			for(ProductDto productDto : list) {
				resp.getWriter().print(productDto.getNo());
				resp.getWriter().print(" / ");
				resp.getWriter().print(productDto.getName());
				resp.getWriter().print(" / ");
				resp.getWriter().print(productDto.getType());
				resp.getWriter().print(" / ");
				resp.getWriter().print(productDto.getPrice());
				resp.getWriter().print("원");
				resp.getWriter().print(" / ");
				resp.getWriter().print(productDto.getMadeDate());
				resp.getWriter().print(" / ");
				resp.getWriter().print(productDto.getExpireDate());
				resp.getWriter().println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}

	}
}
