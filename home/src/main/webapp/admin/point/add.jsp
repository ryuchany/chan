<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 --%>

<%-- 처리 --%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>포인트 상품 등록</h2>

<form action="add.txt" method="post">
	상품이름 : <input type="text" name="coinName" required>
	<br><br>
	상품금액 : <input type="number" name="coinAmount" required>
	<br><br>
	<input type="submit" value="등록">
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>