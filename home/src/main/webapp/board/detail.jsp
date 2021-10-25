<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 입력 : boardNo --%>
<%
int boardNo = Integer.parseInt(request.getParameter("boardNo"));
%>

<%-- 처리 : --%>
<%
BoardDao boardDao = new BoardDao();
BoardDto boardDto = boardDao.get(boardNo);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>게시글 상세 보기</h2>

<table border="1" width="300">
	<tbody>
		<tr>
			<th>작성번호</th>
			<td><%=boardDto.getBoardNo()%></td>
		</tr>
		<tr>
			<th width="25%">작성자</th>
			<td><%=boardDto.getBoardWriter()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=boardDto.getBoardTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=boardDto.getBoardContent()%></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=boardDto.getBoardTime()%></td>
		</tr>
	</tbody>
</table>

<%
	String memberId = (String) session.getAttribute("ses");
%>

<%
	if(memberId != null && memberId.equals(boardDto.getBoardWriter())) {
%>
	<a href="edit.jsp?boardNo=<%=boardDto.getBoardNo()%>">수정</a>
	<a href="delete.txt?boardNo=<%=boardDto.getBoardNo()%>">삭제</a>
<%}%>
	<a href="list.jsp">목록</a>














<jsp:include page="/template/footer.jsp"></jsp:include>