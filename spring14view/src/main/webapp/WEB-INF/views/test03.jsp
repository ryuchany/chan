<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	컨트롤러에서 설정한 데이터 두 개를 표현식과 EL로 각각 출력
	1. 세션에 들어있는 memberId
	2. Model에 들어있는 lotto
	
	EL에서는 세션의 데이터를 접근할 때 sessionScope라는 내장객체를 사용한다.
	EL에서는 Model의 데이터를 접근할 때 requestScope라는 내장객체를 사용한다.
	(중요) 이름이 겹치지 않는다면 내장객체명은 생략이 가능하다.
--%>

<h1>memberId = <%=session.getAttribute("memberId")%></h1>
<h1>memberId = ${sessionScope.memberId}</h1>
<h1>memberId = ${memberId}</h1>

<h1>lotto = <%=request.getAttribute("lotto")%></h1>
<h1>lotto = ${requestScope.lotto}</h1>
<h1>lotto = ${lotto}</h1>

<%-- 
	ex : 로그인 여부를 true/false로 출력하고 싶은 경우
--%>
<h1>로그인 여부 : <%=session.getAttribute("memberId") != null%></h1>
<h1>로그인 여부 : ${sessionScope.memberId != null}</h1>
<h1>로그인 여부 : ${memberId != null}</h1>
<h1>로그인 여부 : ${not empty memberId}</h1>

<%-- 
	ex : 관리자인지 판단하여 출력(관리자는 ID가 khmaster입니다)
	
	= EL을 사용하면 식이 줄어들고 NULL 걱정을 덜 하게 되며 가독성이 좋아진다
--%>

<h1>관리자인가? <%=session.getAttribute("memberId") != null && session.getAttribute("memberId").equals("khmaster")%></h1>
<h1>관리자인가? ${memberId != null && memberId == "khmaster"}</h1>
<h1>관리자인가? ${memberId == "khmaster"}</h1>
<h1>관리자인가? ${memberId == 'khmaster'}</h1>
<h1>관리자인가? ${memberId eq 'khmaster'}</h1>