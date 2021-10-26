<%@page import="home.beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 검색분류(column), 검색어(keyword) --%>
<%
	String column = request.getParameter("column");
	String keyword = request.getParameter("keyword");
%>

<%-- 처리 --%>
<%
	boolean search = column != null && !column.isEmpty() && keyword != null && !keyword.isEmpty();
	
	BoardDao boardDao = new BoardDao();
	List<BoardDto> list;
	if(search){ 
		list = boardDao.search(column, keyword);
	}
	else{
		list = boardDao.list();
	}
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 게시판</h2>
<h6>타인에 대한 무분별한 비판은 제재 대상입니다</h6>

<a href="write.jsp">글쓰기</a>
<br><br>

<table border="1" width="90%">
	<thead>
		<tr>
			<th>번호</th>
			<th width="45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody align="center">
		<%for(BoardDto boardDto : list){ %>
		<tr>
			<td><%=boardDto.getBoardNo()%></td>
			<td align="left"><a href="detail.jsp?boardNo=<%=boardDto.getBoardNo()%>"><%=boardDto.getBoardTitle()%></a></td>
			<td><%=boardDto.getBoardWriter()%></td>
			<td><%=boardDto.getBoardTime()%></td>
			<td><%=boardDto.getBoardRead()%></td>
		</tr>
		<%} %>
	</tbody>
</table>

<br>
<a href="write.jsp">글쓰기</a>

<!-- 페이지 네비게이터 -->
<br><br>
[이전] 1 2 3 4 5 6 7 8 9 10 [다음]
<br><br>

<!-- 검색창 -->
<form action="list.jsp" method="get">

	<select name="column">
		<%if(column != null && column.equals("board_title")){ %>
		<option value="board_title" selected>제목</option>
		<%}else{ %>
		<option value="board_title">제목</option>
		<%} %>

		<%if(column != null && column.equals("board_content")){ %>
		<option value="board_content" selected>내용</option>
		<%}else{ %>
		<option value="board_content">내용</option>
		<%} %>

		<%if(column != null && column.equals("board_writer")){ %>
		<option value="board_writer" selected>작성자</option>
		<%}else{ %>
		<option value="board_writer">작성자</option>
		<%} %>

	</select>

	<%if(keyword == null){ %>
	<input type="search" name="keyword" placeholder="검색어 입력" required>
	<%}else{ %>
	<input type="search" name="keyword" placeholder="검색어 입력" required value="<%=keyword%>">
	<%} %>

	<input type="submit" value="검색">

</form>


<jsp:include page="/template/footer.jsp"></jsp:include>