<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 답글일 경우에는 boardSuperno라는 값이 전달된다. --%>
<%
	String boardSuperno = request.getParameter("boardSuperno");
%>

<%-- 처리 --%>
<%
	boolean answer = boardSuperno != null;
	String title = answer ? "답글 작성" : "새글 작성";
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>


<form action="write.txt" method="post" enctype="multipart/form-data">

<%-- 답글일 경우에는 반드시 "상위글번호(boardSuperno)" 를 처리페이지로 전송해야 한다 --%>
<%if(answer){ %>
<input type="hidden" name="boardSuperno" value="<%=boardSuperno%>">
<%} %>

<div class="container-800 container-center">

	<!-- 제목 -->
	<div class="row">
		<h2><%=title%></h2>		
	</div>

	<div class="row">
		<label>제목</label>
		<input type="text" name="boardTitle" required class="form-input">
	</div>

	<div class="row">
		<label>내용</label>
		<textarea name="boardContent" required rows="10" class="form-input"></textarea>
	</div>

	<div class="row">
		<label class="form-block">첨부파일</label>
		<input type="file" name="attach" class="form-input form-inline">
	</div>

	<div class="row right">
		<a href="list.jsp" class="form-link-btn">목록</a> 
		<input type="submit" value="등록" class="form-btn form-inline">
	</div>

</div>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>