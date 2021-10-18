<%@page import="web09.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 --%>    
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
%>

<%-- 처리 --%>
<%
	boolean search = column != null && keyword != null;
	
	ProductDao productDao = new ProductDao();
	List<ProductDto> list;
	if(search){
		list = productDao.select(column, keyword);
	}
	else{
		list = productDao.select();
	}
%>

<%-- 출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>

	<!-- 제목 -->
	<%if(search){ %>
	<h1>상품 검색</h1>
	<%}else{ %>
	<h1>상품 목록</h1>
	<%} %>

	<!-- 검색창 -->
	<form action="test07.jsp">
		<fieldset>
			<legend>검색 조건 설정</legend>

			<select name="column">
				<option value="name">이름</option>
				<option value="type">유형</option>
			</select>

			<input type="search" name="keyword" required>

			<input type="submit" value="검색">

		</fieldset>
	</form>

	<!-- 결과 테이블 -->
	<table border="1" width="600">

		<!-- 테이블 제목 -->
		<thead>
			<tr>
				<th>no</th>
				<th>name</th>
				<th>type</th>
				<th>price</th>
				<th>made</th>
				<th>expire</th>
			</tr>
		</thead>

		<!-- 테이블 데이터 -->
		<tbody align="center">

			<%for(ProductDto productDto : list){ %>
			<tr>
				<td><%=productDto.getNo()%></td>
				<td align="left"><%=productDto.getName()%></td>
				<td><%=productDto.getType()%></td>
				<td><%=productDto.getPrice()%></td>
				<td><%=productDto.getMadeDate()%></td>
				<td><%=productDto.getExpireDate()%></td>
			</tr>
			<%} %>

		</tbody>

	</table>	

</body>
</html> 

