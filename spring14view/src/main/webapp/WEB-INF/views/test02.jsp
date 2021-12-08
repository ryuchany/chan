<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL이 표현식보다 좋은게 뭐길래?
	1. null에 대해서 유연하게 처리한다
	2. 각종 페이지에서 필요한 데이터에 손쉽게 접근할 수 있도록 "내장객체"가 존재한다.
		= param : 파라미터에 접근할 수 있는 내장객체
		= paramValues : 파라미터가 여러개일 경우 접근할 수 있는 내장객체
	
	파라미터를 처리해보면 무슨 의미인지 알 수 있다.
--%>

<%
	//number라는 파라미터를 수신하는 코드
	//int number = Integer.parseInt(request.getParameter("number"));
%>

<%-- <h1>number = <%=number%></h1> --%>
<h1>number = <%=request.getParameter("number")%></h1>
<h1>number = ${param.number}</h1>


<%if(request.getParameter("number") == null){ %>
<input type="text" name="number">
<%}else{ %>
<input type="text" name="number" value="<%=request.getParameter("number")%>">
<%} %>

<br><br>

<input type="text" name="number" value="${param.number}">