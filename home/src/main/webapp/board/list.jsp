<%@page import="home.beans.Pagination"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//Pagination 모듈을 이용하여 계산을 처리하도록 위임
	Pagination pagination = new Pagination(request);
	//pagination.setPageSize(15);
	//pagination.setBlockSize(5);   
	pagination.calculate(); 	
%>

<%=pagination.toString()%>

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
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>상위글</th>
			<th>그룹</th>
			<th>차수</th>
		</tr>
	</thead>
	<tbody align="center">
		<%for(BoardDto boardDto : pagination.getList()){ %>
		<tr>
			<td><%=boardDto.getBoardNo()%></td>
			<td align="left">
			
				<%-- 
					게시글의 제목을 출력하기 전에 차수에 따라 띄어쓰기를 진행한다
					띄어쓰기는 HTML 특수문자인 &nbsp; 을 사용한다.
					답변글에는 reply icon을 추가로 출력한다. 
				--%>
				<%
					//if(boardDto.getBoardDepth() > 0){
					if(boardDto.hasDepth()){ 
				%>
					<%for(int i=0; i < boardDto.getBoardDepth(); i++){ %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<%} %>

					<img src="<%=request.getContextPath()%>/resource/image/reply.png" width="15" height="15">
				<%} %>
				<a href="detail.jsp?boardNo=<%=boardDto.getBoardNo()%>">
					<%=boardDto.getBoardTitle()%>
				</a>

				<!-- 제목 뒤에 댓글 개수를 출력한다 -->
				<%
				//if(boardDto.getBoardReply() > 0){
				if(boardDto.isReplyExist()){
				%>
					[<%=boardDto.getBoardReply()%>]
				<%} %>
			</td>
			<td><%=boardDto.getBoardWriter()%></td>
			<td><%=boardDto.getBoardTime()%></td>
			<td><%=boardDto.getBoardRead()%></td>
			<td><%=boardDto.getBoardSuperno()%></td>
			<td><%=boardDto.getBoardGroupno()%></td>
			<td><%=boardDto.getBoardDepth()%></td>
		</tr>
		<%} %>
	</tbody>
</table>

<br>
<a href="write.jsp">글쓰기</a>

<!-- 페이지 네비게이터 -->
<br><br>
<%if(pagination.isPreviousAvailable()){ %>
	<%if(pagination.isSearch()){ %>
	<!-- 검색용 링크 -->
	<a href="list.jsp?column=<%=pagination.getColumn()%>&keyword=<%=pagination.getKeyword()%>&p=<%=pagination.getPreviousBlock()%>">&lt;</a>
	<%} else { %>
	<!-- 목록용 링크 -->
	<a href="list.jsp?p=<%=pagination.getPreviousBlock()%>">&lt;</a>
	<%} %>
	<%} else { %>
	<a>&lt;</a>
	<%} %>

<%for(int i = pagination.getStartBlock(); i <= pagination.getRealLastBlock(); i++){ %>
	<%if(pagination.isSearch()){ %>
	<!-- 검색용 링크 -->
	<a href="list.jsp?column=<%=pagination.getColumn()%>&keyword=<%=pagination.getKeyword()%>&p=<%=i%>"><%=i%></a>
	<%}else{ %>
	<!-- 목록용 링크 -->
	<a href="list.jsp?p=<%=i%>"><%=i%></a>
	<%} %>
<%} %>

<%if(pagination.isNextAvailable()){ %>
	<%if(pagination.isSearch()){ %>
		<!-- 검색용 링크 -->
		<a href="list.jsp?column=<%=pagination.getColumn()%>&keyword=<%=pagination.getKeyword()%>&p=<%=pagination.getNextBlock()%>">&gt;</a>
	<%} else { %>
		<!-- 목록용 링크 -->
		<a href="list.jsp?p=<%=pagination.getNextBlock()%>">&gt;</a>
	<%} %> 
<%} else {%>
	<a>&gt;</a>
<%} %>
<br><br>

<!-- 검색창 -->
<form action="list.jsp" method="get">

	<select name="column">
		<%if(pagination.columnIs("board_title")){ %>
		<option value="board_title" selected>제목</option>
		<%}else{ %>
		<option value="board_title">제목</option>
		<%} %>

		<%if(pagination.columnIs("board_content")){ %>
		<option value="board_content" selected>내용</option>
		<%}else{ %>
		<option value="board_content">내용</option>
		<%} %>

		<%if(pagination.columnIs("board_writer")){ %>
		<option value="board_writer" selected>작성자</option>
		<%}else{ %>
		<option value="board_writer">작성자</option>
		<%} %>

	</select>

	<input type="search" name="keyword" placeholder="검색어 입력" required value="<%=pagination.getKeywordString()%>">

	<input type="submit" value="검색">

</form>


<jsp:include page="/template/footer.jsp"></jsp:include>