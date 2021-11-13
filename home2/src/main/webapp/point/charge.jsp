<%@page import="home.beans.CoinDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.CoinDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 : 없음 --%>

<%-- 처리 : 포인트상품 목록 --%>    
<%
	CoinDao coinDao = new CoinDao();
	List<CoinDto> list = coinDao.list();
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-400 container-center">

	<div class="row center">
		<h2>포인트 충전</h2>
	</div>

	<div class="row">
		<hr>
		<h3>원하시는 상품을 선택하세요</h3>
		<hr>
	</div>

	<form action="charge.txt" method="post">
	<table class="table table-stripe">
		<thead>
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>Point</th>
			</tr>
		</thead>
		<tbody>
			<%for(CoinDto coinDto : list){ %>
			<tr>
				<td><input type="radio" name="coinNo" value="<%=coinDto.getCoinNo()%>"></td>
				<td class="left"><%=coinDto.getCoinName()%></td>
				<td>(<%=coinDto.getCoinAmount()%> point)</td>
			</tr>
			<%} %>
		</tbody>
	</table>

	<div class="row">
		<input type="submit" value="충전" class="form-btn">
	</div>
	</form>		

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>