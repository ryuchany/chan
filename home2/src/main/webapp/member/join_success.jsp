<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-300 container-center">
	<div class="row center">
		<h2>회원 가입 완료</h2>
	</div>
	<hr>
	<div class="row center">
		<a href="login.jsp" class="link-btn-block">로그인하기</a>	
	</div>
	<div class="row center"> 
		<a href="<%=request.getContextPath()%>" class="link-btn-block">메인페이지 보기</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>