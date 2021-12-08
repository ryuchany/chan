<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
	dice 라는 이름으로 주사위 랜덤값이 첨부되어 온다.
--%>

<h1>주사위 : ${requestScope.dice}</h1>
<h1>주사위 : ${dice}</h1>

<%-- 조건식은 EL로 작성해야 한다. --%>
<c:if test="${dice % 2 == 0}">
	<h1>짝!</h1>
</c:if>
<c:if test="${dice % 2 != 0}">
	<h1>홀!</h1>
</c:if>

<c:choose>
	<c:when test="${dice % 2 == 0}">
		<h1>짝!</h1>
	</c:when>
	<c:otherwise>
		<h1>홀!</h1>
	</c:otherwise>
</c:choose>