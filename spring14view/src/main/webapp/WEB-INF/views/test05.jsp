<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL
	= JSP Standard Tag Library
	= JSP 표준 태그 모음
	= JSP의 프로그래밍 처리를 태그화 시키기 위해서 등장한 라이브러리
	= if, for, try~catch 등을 태그화 시킬 수 있다
	= 총 5종류가 있다(core, format, sql, xml, function)
	= core를 제외한 나머지는 전부다 계산을 위한 태그이므로 배우지 않는다.
	= EL과 궁합이 잘 맞는다
	= 사용하려면 반드시 JSTL jar 가 필요하고 등록 설정을 해야 한다.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	c:set 은 변수를 만드는 태그
	= 자료형을 따로 관리하지 않는다(EL과 같은 마인드)
	= 내부적으로는 pageContext에 데이터를 설정하도록 구현되어 있다.
	= 만들어진 태그는 EL로 출력이 가능하다.
 --%>
<c:set var="a" value="10"></c:set>

<h1>a = ${pageScope.a}</h1>
<h1>a = ${a}</h1>

<c:set var="a" value="hello"></c:set>
<h1>a = ${a}</h1>

<c:remove var="a"/>
<h1>a = ${a}</h1>
<h1>a = ${empty a}</h1>

<h1><%=request.getContextPath()%></h1>
<h1>${pageContext.request.contextPath}</h1>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<h1><a href="${root}/hello">Hello</a></h1>