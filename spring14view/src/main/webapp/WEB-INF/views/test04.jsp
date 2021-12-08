<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	전송되는 Model에 객체가 있을 경우
	= 변수명을 작성하면 getter 메소드를 추론해서 불러온다.
--%>

<h1>${requestScope.productDto.getName()}</h1>
<h1>${productDto.getName()}</h1>
<h1>${productDto.name}</h1>