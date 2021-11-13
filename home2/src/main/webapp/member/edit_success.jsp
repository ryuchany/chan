<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-300 container-center">
	<div class="row center">
		<h2>개인정보 변경 완료</h2>	
	</div>
	<hr>
	<div class="row center">
		<a href="mypage.jsp" class="link-btn-block">내 정보 보기</a>
	</div>
	<div class="row center">
		<a href="<%=request.getContextPath()%>" class="link-btn-block">메인 페이지로</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>