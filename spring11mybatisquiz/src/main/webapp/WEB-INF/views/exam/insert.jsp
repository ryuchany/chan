<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>학생 점수 등록</h1>

<form method="post">
	학생명 : <input type="text" name="student" required>
	<br><br>
	과목명 : <input type="text" name="subject" required>
	<br><br>
	유형 : <input type="text" name="type" required>
	<br><br>
	점수 : <input type="text" name="score" required>
	<br><br>
	<input type="submit" value="등록">
</form>