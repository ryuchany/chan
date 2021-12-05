<%@page import="com.kh.spring09.entity.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	List<ProductDto> list = (List<ProductDto>) request.getAttribute("list");
 %>
 
 <h1>상품 목록</h1>

<%for(ProductDto productDto : list){%>
	<div><%=productDto%></div>
<%}%>