<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 --%>

<%-- 처리 --%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>게시글 작성</h2>

<form action="write.txt" method="post">

<table border="0">
	<tbody>
		<tr>
			<th>제목</th>
			<td><input type="text" name="boardTitle" required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="boardContent" required rows="10" cols="60"></textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="등록">
			</td>
		</tr>
	</tfoot>
</table>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>