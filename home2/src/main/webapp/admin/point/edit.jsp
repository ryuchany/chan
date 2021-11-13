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

<style>
	.link-btn {
		padding:0.75rem;
		font-size:20px;
	}
</style>



<form action="edit.txt" method="post">
<input type="hidden" name="coinNo" value="<%=coinDto.getCoinNo()%>">

<div class="container-400 container-center">

	<div class="row center">
		<h2>포인트 상품 수정</h2>
	</div>

	<div class="row">
		<label>상품이름</label>
		<input type="text" name="coinName" value="<%=coinDto.getCoinName()%>" class="form-input">
	</div>

	<div class="row">
		<label>상품금액</label>
		<input type="number" name="coinAmount" value="<%=coinDto.getCoinAmount()%>" class="form-input">
	</div>

	<div class="row right">
		<a href="list.jsp" class="link-btn">목록</a>
		<input type="submit" value="수정" class="form-btn form-inline">	
	</div>
</div>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>