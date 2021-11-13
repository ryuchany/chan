<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
<style>
	.link-btn {
		padding:0.75rem;
		font-size:20px;
	}
</style>

<form action="add.txt" method="post">
<div class="container-400 container-center">
	<div class="row center">
		<h2>포인트 상품 등록</h2>		
	</div>

	<div class="row">
		<label>상품이름</label>
		<input type="text" name="coinName" required class="form-input">
	</div>

	<div class="row">
		<label>상품금액</label>
		<input type="number" name="coinAmount" required class="form-input">
	</div>

	<div class="row right">
		<a href="list.jsp" class="link-btn">목록</a>
		<input type="submit" value="등록" class="form-btn form-inline">	
	</div>
</div>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>