<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//로그인 상태인지 아닌지 판정하는 코드
	//= 로그인 상태라는 것은 세션에 존재하는 ses라는 데이터가 null이 아니라는 것이다.
	//= jsp에서는 session이라는 내장객체가 존재하기 때문에 바로 접근이 가능하다.
	String ses = (String) session.getAttribute("ses");	
	boolean login = ses !=null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>
	<%--
		홈페이지를 4단으로 구성
		= 1단 : 메인로고 등 대표정보
		= 2단 : 각종 기능으로 이동할 수 있는 메뉴
		= 3단 : 홈페이지에 표시될 내용들..
		= 4단 : 기업정보 or 제휴컨텐츠 등... 
	--%>
	<table border="1" width="1000" align="center">
		<tbody align="center">
			<tr>
				<td>
					<br>
					<img src="/home/resource/image/apple.png" width="250" height="50">
					<h3>Apple 공식사이트 (ses = <%=ses%>))</h3>
				</td>
			</tr>
			<tr>
				<td>
					<!-- 
						홈페이지 메뉴
						= 현재 페이지(header.jsp)는 템플릿 페이지이다.
						= 직접 실행되는 것이 아니라 특정 페이지에 합쳐져서 실행된다
						= 어느 페이지에서 실행될지, 기준점 주소가 어딘지 알 수 없다
						= (결론) 상대경로 사용 불가
						
						= 절대경로는 context root path 를 적어야 하는데 이것은 변경될 수 있다.
						= 변경될 때마다 일일이 수정할 수는 없기 때문에 context path를 구하는 명령이 필요하다.
						= request.getContextPath() 명령을 이용하여 구할 수 있다.
					 -->
					 <%
					 	String root = request.getContextPath();
					 %>
					<a href="<%=root%>/index.jsp">홈으로</a>
					<a href="<%=root%>/member/join.jsp">회원가입</a>
					<a href="<%=root%>/member/login.jsp">로그인</a>
					<a href="#">로그아웃</a>
					<a href="#">내정보</a>
					<a href="#">게시판</a>
				</td>
			</tr>
			<tr>
				<td>