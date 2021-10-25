<%@page import="home.beans.CoinDto"%>
<%@page import="home.beans.CoinDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 --%>    
<%
	int coinNo = Integer.parseInt(request.getParameter("coinNo"));
%>
<%-- 처리 --%>
<%
	CoinDao coinDao = new CoinDao();
	CoinDto coinDto = coinDao.get(coinNo);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>포인트 상품 수정</h2>

<form action="edit.txt" method="post">
	<input type="hidden" name="coinNo" value="<%=coinDto.getCoinNo()%>">
	<br><br>
	상품이름 : <input type="text" name="coinName" value="<%=coinDto.getCoinName()%>">
	<br><br>
	상품금액 : <input type="number" name="coinAmount" value="<%=coinDto.getCoinAmount()%>">
	<br><br>
	<input type="submit" value="수정">
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>