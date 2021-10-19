<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 현재 로그인한 회원ID - String memberId --%>
<%
	String memberId = (String) session.getAttribute("ses");
%>

<%-- 처리 : 회원정보(MemberDto) --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.get(memberId);
%>

<%-- 출력 --%>   
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 상세 정보</h2>

<table border="1" width="300">
	<tbody>
		<tr>
			<th width="25%">아이디</th>
			<td><%=memberDto.getMemberId()%></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><%=memberDto.getMemberNick()%></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=memberDto.getMemberBirthDay()%></td>
		</tr>	
		<tr>
			<th>이메일</th>
			<td><%=memberDto.getMemberEmailString()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=memberDto.getMemberPhoneString()%></td>
		</tr>		
		<tr>
			<th>가입일시</th>
			<td><%=memberDto.getMemberJoin()%></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><%=memberDto.getMemberPoint()%></td>
		</tr>
		<tr>
			<th>등급</th>
			<td><%=memberDto.getMemberGrade()%></td>
		</tr>							
	</tbody>
</table>

<h3><a href="password.jsp">비밀번호 변경</a></h3>
<h3><a href="edit.jsp">개인정보 변경</a></h3>
<h3><a href="delete.jsp">회원 탈퇴</a></h3>

<jsp:include page="/template/footer.jsp"></jsp:include>