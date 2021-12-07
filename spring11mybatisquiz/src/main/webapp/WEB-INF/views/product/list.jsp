<%@page import="com.kh.spring11.entity.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터가 요청정보(request)에 포워드되서 전달된다.
	//= 포워드된 데이터는 request.getAttribute("이름") 으로 추출이 가능하며 Object 형태
	
	List<ProductDto> list = (List<ProductDto>)request.getAttribute("list");
%>

<% for(ProductDto productDto : list) { %>
	<p>
		<a href="detail?no=<%=productDto.getNo()%>">파라미터방식</a>
		<a href="detail/<%=productDto.getNo()%>">경로변수방식</a>
		<%=productDto.toString()%>
	</p>
<% } %>