<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>결제 정보 확인</h1>

<form method="post">
	<input type="hidden" name="item_name" value="테스트결제상품">
	<input type="hidden" name="quantity" value="1">
	<input type="hidden" name="total_amount" value="50000">

	<h3>상품명 : 테스트결제상품</h3>
	<h3>수량 : 1</h3>
	<h3>결제금액 : 50000원</h3>

	<input type="submit" value="결제하기">
</form>