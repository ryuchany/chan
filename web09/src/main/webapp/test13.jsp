<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 파일 업로드 페이지 -->

<h2>GET방식 업로드 테스트</h2>
<form action="test14.jsp" method="get">
	<input type="file" name="attach">
	<input type="submit" value="업로드">
</form>

<h2>POST방식 업로드 테스트(1) - 기존 방식</h2>
<form action="test14.jsp" method="post">
	<input type="file" name="attach">
	<input type="submit" value="업로드">
</form>

<h2>POST방식 업로드 테스트(2) - 멀티파트 방식</h2>
<form action="test14.jsp" method="post" enctype="multipart/form-data">
	<input type="file" name="attach" accept=".jpg, .png, .gif">
	<input type="submit" value="업로드">
</form>