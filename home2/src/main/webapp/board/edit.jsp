<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 --%>
<%
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
%>

<%-- 처리 --%>
<%
	BoardDao boardDao = new BoardDao();
	BoardDto boardDto = boardDao.get(boardNo);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<form action="edit.txt" method="post">
<input type="hidden" name="boardNo" value="<%=boardDto.getBoardNo()%>">

<div class="container-800 container-center">
	<div class="row center">
		<h2>게시글 수정</h2>	
	</div>

	<div class="row">
		<label>제목</label>
		<input type="text" name="boardTitle" required value="<%=boardDto.getBoardTitle()%>" class="form-input">
	</div>

	<div class="row">
		<label>내용</label>
		<textarea name="boardContent" required 
					rows="10" class="form-input"><%=boardDto.getBoardContent()%></textarea>
	</div>

	<div class="row right">
		<a href="list.jsp" class="form-link-btn">목록</a>
		<input type="submit" value="수정" class="form-btn form-inline">
	</div>
</div>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>