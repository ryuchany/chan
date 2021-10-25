<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%
String memberId = (String) session.getAttribute("ses");
%>
<h2>게시글 작성</h2>

<form action="write.txt" method="post" >
	<table>
		<thead>
			<tr>
				<th>게시글 작성</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text"placeholder="글 제목" name="boardTitle" maxlength="50"></td>
			</tr>
				<tr>
				<td><textarea placeholder="글 내용" name="boardContent" maxlength="2048" ></textarea></td>
				</tr>
		</tbody>
	</table>
			
	<input type="submit" value="글쓰기">
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>