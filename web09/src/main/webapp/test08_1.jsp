<%@page import="web09.beans.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 : column, keyword --%>
<% 
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
%>

<%-- 처리 : MemberDao --%>    
<%
	boolean search = column != null && keyword != null;
	
	MemberDao memberDao = new MemberDao();
	//List<MemberDto> list = memberDao.list() or memberDao.search(column, keyword);
	List<MemberDto> list;
	if(search){
		list = memberDao.search(column, keyword);
	}
	else{
		list = memberDao.list();
	}
	
	//화면에 출력하기 위한 값을 준비
	String title;
	if(search){
		title = "회원 검색";
	}
	else{
		title = "회원 목록";
	}
%>

<%-- 출력 : HTML 방식 + for, if --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>

	<!-- 제목 영역 -->
	<h1><%=title%></h1>

	<!-- 검색창 -->

	<!-- 테이블 -->
	<table border="1" width="900">
		<thead>
			<tr>
				<th>ID</th>
				<th>닉네임</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>등급</th>
				<th>포인트</th>
			</tr>
		</thead>

		<tbody align="center">
			<%for(MemberDto memberDto : list){ %>
			<tr>
				<td><%=memberDto.getMemberId()%></td>
				<td><%=memberDto.getMemberNick()%></td>
				<td><%=memberDto.getMemberBirthDay()%></td>
				<td><%=memberDto.getMemberEmailString()%></td>
				<td><%=memberDto.getMemberPhoneString()%></td>
				<td><%=memberDto.getMemberGrade()%></td>
				<td><%=memberDto.getMemberPoint()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>

