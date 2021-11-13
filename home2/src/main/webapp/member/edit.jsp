<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 : memberId (session) --%>
<%
	String memberId= (String) session.getAttribute("ses");
%>

<%-- 처리 --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.get(memberId);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>


<form action="edit.txt" method="post">

<div class="container-400 container-center">
	<div class="row center">
		<h2>개인정보 변경</h2>	
	</div>

	<div class="row">
		<label>비밀번호</label>
		<input type="password" name="memberPw" required class="form-input">	
	</div>

	<div class="row">
		<label>닉네임</label>
		<input type="text" name="memberNick" value="<%=memberDto.getMemberNick()%>" required class="form-input">
	</div>
	
	<div class="row">
	<label>생년월일</label>
	<input type="date" name="memberBirth" value="<%=memberDto.getMemberBirthDay()%>" required class="form-input">
	</div>
	
	<div class="row">
	<label>이메일</label>
	<input type="email" name="memberEmail" value="<%=memberDto.getMemberEmailString()%>" class="form-input">
	</div>
	
	<div class="row">
	<label>전화번호</label>
	<input type="tel" name="memberPhone" value="<%=memberDto.getMemberPhoneString()%>" class="form-input">
	</div>		

	<div class="row right">
		<input type="submit" value="변경" class="form-btn form-inline">
	</div>
</div>

</form>

<%if(request.getParameter("error") != null){ %>
	<h4><font color="red">입력하신 정보가 일치하지 않습니다</font></h4>
<%} %>

<jsp:include page="/template/footer.jsp"></jsp:include>