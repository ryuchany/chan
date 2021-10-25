<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>


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

<h2>게시글 수정 하기</h2>

<form action="edit.txt" method="post">

	<table>
		<tbody>
			<tr>
				<th>번호</th>
				<td>
					<input type="text" name="boardNo" required>
				</td>
			</tr>		
			<tr>
				<th>제목</th>
				<td><input type="text" name="boardTitle" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="boardContent" required></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="변경">
				</td>
			</tr>
		</tfoot>
	</table>

</form>

<%
if (request.getParameter("error") != null) {
%>
<h4>
	<font color="red">입력하신 정보가 일치하지 않습니다</font>
</h4>
<%
}
%>

<jsp:include page="/template/footer.jsp"></jsp:include>