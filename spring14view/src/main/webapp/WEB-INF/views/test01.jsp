<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	JSP에서 데이터를 출력하는 방법은 여러 가지가 있다.
	- 표현식(Expression) : <%= 값 %>
	- 표현언어(Expression Language, EL) : ${값}
	
	궁극적으로 자바 진영에서 추구하는 웹 개발 방식은 MVC 방식이고 따라서 JSP는 View로 역할이 제한된다.
	JSP에서 프로그래밍적인 처리를 하지 않고 단지 컨트롤러에서 전달받는 데이터 등을 출력하는 용도로 사용한다.
	더 나아가면 스프링은 JSP를 표준으로 채택하지 않고 Thymeleaf 라는 기술을 표준으로 채택한다.
--%>

<%
	int a = 10;
	pageContext.setAttribute("a", 100);
%>

<h1>a = <%=a%></h1>
<h1>a = ${a}</h1>

<h1>10 + 20 = <%=10 + 20%></h1>
<h1>10 + 20 = ${10 + 20}</h1>