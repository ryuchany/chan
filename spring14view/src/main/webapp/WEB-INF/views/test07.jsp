<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	반복문은 종류가 2가지이다.
	1. 반복수를 이용한 반복
		for(int i=1; i <= 10; i++){
			System.out.println(i);
		}
	2. Iteration 반복(확장 반복)
		for(ProductDto productDto : list){
			System.out.println(productDto);
		}
 --%>

<c:forEach var="i" begin="1" end="10" step="1">
	<h3>i = ${i}</h3>
</c:forEach>

<c:forEach var="productDto" items="${list}">
	<h3>${productDto.name} / ${productDto.price}</h3>
</c:forEach>