<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form method="post">

<div class="container-400 container-center">
	<div class="row center">
		<h1>회원가입</h1>
	</div>
	<div class="row">
		<label>아이디</label>
		<input type="text" name="memberId" required class="form-input">
	</div>
	<div class="row">
		<label>비밀번호</label>
		<input type="password" name="memberPw" required class="form-input">
	</div>
	<div class="row">
		<label>닉네임</label>
		<input type="text" name="memberNick" required class="form-input">
	</div>
	<div class="row">
		<label class="form-block">생년월일</label>
		<input type="date" name="memberBirth" required class="form-input form-inline">
	</div>
	<div class="row">
		<label>이메일</label>
		<input type="email" name="memberEmail" class="form-input">
	</div>
	<div class="row">
		<label>전화번호</label>
		<input type="tel" name="memberPhone" class="form-input">
	</div>
	<div class="row">
		<input type="submit" value="가입" class="form-btn">
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>