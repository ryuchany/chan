<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>웹소켓 예제</h1>

<h2>현재 로그인 상태 : ${userId != null}</h2>

<c:if test="${userId != null}">
	<h2>회원 아이디 : ${userId}</h2>
</c:if>

<c:choose>
	<c:when test="${userId == null}">
	<form action="login" method="post">
		<input type="text" name="userId" required>
		<button type="submit">로그인</button>
	</form>
	</c:when>
	<c:otherwise>
		<button type="button" onclick="location.href='logout';">로그아웃</button>
	</c:otherwise>
</c:choose>


<h2><a href="basic">기본 웹소켓 예제</a></h2>
<h2><a href="manage">인원 관리 웹소켓 예제</a></h2>
<h2><a href="message">메세지 전송 웹소켓 예제</a></h2>
<h2><a href="json">JSON 전송 웹소켓 예제</a></h2>
<h2><a href="member">회원용 웹소켓 예제</a></h2>
<h2><a href="sockjs">SockJS 웹소켓 예제</a></h2>
<h2><a href="multi">멀티채널 웹소켓 예제</a></h2>