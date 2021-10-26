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

<h2>게시글 수정</h2>

<form action="edit.txt" method="post">
<input type="hidden" name="boardNo" value="<%=boardDto.getBoardNo()%>">

<table border="0">
	<tbody>
		<tr>
			<th>제목</th>
			<td><input type="text" name="boardTitle" required value="<%=boardDto.getBoardTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="boardContent" required 
					rows="10" cols="60"><%=boardDto.getBoardContent()%></textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="수정">
			</td>
		</tr>
	</tfoot>
</table>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>