<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%-- 입력 : memberId (parameter) --%>
<%
	String memberId = request.getParameter("memberId");
%>

<%-- 처리 --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.get(memberId);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<form action="edit.txt" method="post">
<input type="hidden" name="memberId" required value="<%=memberDto.getMemberId()%>">

<div class="container-400 container-center">
	<div class="row center">
		<h2>회원 정보 수정</h2>
	</div>

	<div class="row">
		<label>아이디</label>
		<input type="text" disabled value="<%=memberDto.getMemberId()%>" class="form-input">
	</div>
	<div class="row">
		<label>닉네임</label>
		<input type="text" name="memberNick" required value="<%=memberDto.getMemberNick()%>" class="form-input">
	</div>
	<div class="row">
		<label>생년월일</label>
		<input type="date" name="memberBirth" required value="<%=memberDto.getMemberBirthDay()%>" class="form-input">
	</div>
	<div class="row">
		<label>이메일</label>
		<input type="email" name="memberEmail" value="<%=memberDto.getMemberEmailString()%>" class="form-input">
	</div>
	<div class="row">
		<label>전화번호</label>
		<input type="tel" name="memberPhone" value="<%=memberDto.getMemberPhoneString()%>" class="form-input">
	</div>
	<div class="row">
		<label>가입일</label>
		<input type="date" value="<%=memberDto.getMemberJoin()%>" disabled class="form-input">
	</div>
	<div class="row">
		<label>포인트</label>
		<input type="number" name="memberPoint" value="<%=memberDto.getMemberPoint()%>" class="form-input">
	</div>
	<div class="row">
		<label class="form-block">등급</label>
		<select name="memberGrade" class="form-input form-inline">
			<%if(memberDto.getMemberGrade().equals("정회원")){ %>
			<option>준회원</option>
			<option selected>정회원</option>
			<option>우수회원</option>
			<%}else if(memberDto.getMemberGrade().equals("우수회원")){ %>
			<option>준회원</option>
			<option>정회원</option>
			<option selected>우수회원</option>
			<%}else { %>
			<option selected>준회원</option>
			<option>정회원</option>
			<option>우수회원</option>
			<%} %>
		</select>
	</div>

	<div class="row">
		<input type="submit" value="수정" class="form-btn">
	</div>
	</div>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>