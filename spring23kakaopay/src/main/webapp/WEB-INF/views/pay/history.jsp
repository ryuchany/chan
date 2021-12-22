<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 이력</h1>

<c:forEach var="buyDto" items="${list}">
	<div>
		${buyDto.no} / ${buyDto.tid} /
		${buyDto.itemName} / ${buyDto.totalAmount} / 
		${buyDto.buyTime} / ${buyDto.status}
		
		<a href="history_detail?no=${buyDto.no}">상세보기</a>		
	</div>
</c:forEach>