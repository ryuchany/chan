<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-400 container-center">
	<div class="row center">
		<h2>관리자 메인 페이지</h2>	
	</div>
	<hr>
	<div class="row center">
		<a href="./member/list.jsp" class="link-btn-block">회원 관리</a>
	</div>
	<div class="row center">
		<a href="./point/list.jsp" class="link-btn-block">포인트상품 관리</a>
	</div>
	<div class="row center">
		<a href="statistics.jsp" class="link-btn-block">사이트 통계</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>