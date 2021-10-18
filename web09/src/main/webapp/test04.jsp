<%--
	Q : product 테이블의 데이터를 조회하여 화면에 출력하시오
 --%>

<%@page import="web09.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 프로그래밍 영역 --%>
<%
	ProductDao productDao = new ProductDao();
	List<ProductDto> list = productDao.select();
%>    

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>

	<h1>상품 목록</h1>

	<%for(ProductDto productDto : list){	 %>
	<h3>[번호] 이름 , 구분 , ???원 , 제조일 ~ 유통기한</h3>
	<%} %>

</body>
</html> 
%>

