<%-- 사용자에게 보이지 않는 JSP 전용 주석 --%>
<!-- 사용자에게 보이는 HTML 전용 주석 -->

<%--
	페이지 설정(Directive)
	= 형식 - <%@ 이름="값" 이름="값" %>
	= language : 페이지에서 사용할 언어(생략 가능)
	= contentType : (중요!) 사용자(브라우저)에게 알려줄 페이지의 형태와 특징
		= 형태를 MIME-TYPE이라고 부르며, 대분류/소분류 형태로 구성되어 있다.
	= pageEncoding : JSP는 내부적으로 Servlet으로 변환되는데 이 때 적용할 글꼴(생략하면 contentType을 따라감)
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP!</h1>
</body>
</html> 