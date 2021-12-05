<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>상품 등록</h1>

<form method="post">
	상품명 : <input type="text" name="name" required>
	<br><br>
	상품타입 : 
	<select name="type" required>
		<option value="">선택하세요</option>
		<option>아이스크림</option>
		<option>주류</option>
		<option>과자</option>
		<option>사탕</option>
	</select>
	<br><br>
	가격 : <input type="number" name="price" required>
	<br><br>	
	제조일 : <input type="date" name="made" required>
	<br><br>
	유통기한 : <input type="date" name="expire" required>
	<br><br>

	<input type="submit" value="등록">
</form>