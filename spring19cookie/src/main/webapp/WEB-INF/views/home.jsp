<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>쿠키 테스트</h1>

<h2><a href="create">쿠키 생성</a></h2>
<h2><a href="drop">쿠키 삭제</a></h2>
<h2><a href="check">쿠키 검사</a></h2>

<%--
	쿠키 확인은 표현식 or 표현언어 모두 가능
	- 표현식으로 확인할 때는 이름을 통한 확인이 불가능(모든 쿠키를 추출한 다음 반복문으로 검사)
	- 표현언어(EL)로 확인할 때는 내장객체를 이용하여 처리 가능
--%>

<h1>쿠키 : ${cookie.test.name} / ${cookie.test.value}</h1>

<c:if test="${cookie.test != null}">
<h1>쿠키가 있습니다!</h1>
</c:if>