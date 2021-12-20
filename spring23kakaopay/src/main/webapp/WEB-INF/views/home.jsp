<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 테스트</h1>

<form action="pay/confirm2" method="get">
<c:forEach var="productDto" items="${list}">
	<div>
		<!-- 체크박스를 선택하면 데이터가 이동하도록 처리 -->
		<input type="checkbox" name="no" value="${productDto.no}">

		${productDto.no} / ${productDto.name} / ${productDto.price}
	</div>
</c:forEach>

<input type="submit" value="구매하기">
</form>