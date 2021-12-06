<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>회원 가입</h1>

<form method="post">
	ID : <input type="text" name="memberId" required>
	<br><br>
	Password : <input type="password" name="memberPw" required>
	<br><br>
	Nickname : <input type="text" name="memberNick" required>
	<br><br>
	Birth : <input type="date" name="memberBirth" required>
	<br><br>
	Email : <input type="email" name="memberEmail">
	<br><br>
	Phone : <input type="tel" name="memberPhone">
	<br><br>
	<input type="submit" value="가입">
</form>