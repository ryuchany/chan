<%@page import="com.kh.spring11.entity.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDto productDto = (ProductDto)request.getAttribute("productDto");
%>

<p>
	<%=productDto.toString()%>
</p>