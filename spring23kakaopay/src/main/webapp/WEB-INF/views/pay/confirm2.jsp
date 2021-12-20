<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제할 상품 정보 확인</h1>

<form action="confirm2" method="post">

<c:forEach var="productDto" items="${list}">
	<input type="hidden" name="no" value="${productDto.no}">
	<div>
		${productDto.no} / ${productDto.name} / ${productDto.price}
	</div>
</c:forEach>

<input type="submit" value="결제하기">

</form>