<%@page import="home.beans.Pagination"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Pagination pagination = new Pagination(request);
	pagination.calculate(); 	
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<style>
	/* 링크를 버튼으로 만드는 스타일 */
	.link-btn {
		display: inline-block;
		padding:0.5rem;
		border:1px solid gray;
		text-decoration: none;
		color:gray;
	}
	.link-btn:hover {
		border-color:black;
		color:black;
	}
</style>

<div class="container-800 container-center">
	<div class="row center">
		<h2>회원 게시판</h2>
	</div>
	<div class="row center">
		<h6>타인에 대한 무분별한 비판은 제재 대상입니다</h6>
	</div>
	<div class="row right">
		<a href="write.jsp" class="link-btn">글쓰기</a>
	</div>
	<div class="row">
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%for(BoardDto boardDto : pagination.getList()){ %>
				<tr>
					<td><%=boardDto.getBoardNo()%></td>
					<td class="left">

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
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<div class="row right">
		<a href="write.jsp" class="link-btn">글쓰기</a>
	</div>
	<div class="row pagination">
		<!-- 이전 버튼 -->
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

		<!-- 페이지 네비게이터 -->
		<%for(int i = pagination.getStartBlock(); i <= pagination.getRealLastBlock(); i++){ %>
			<%if(pagination.isSearch()){ %>
			<!-- 검색용 링크 -->
			<a href="list.jsp?column=<%=pagination.getColumn()%>&keyword=<%=pagination.getKeyword()%>&p=<%=i%>"><%=i%></a>
			<%}else{ %>
			<!-- 목록용 링크 -->
			<a href="list.jsp?p=<%=i%>"><%=i%></a>
			<%} %>
		<%} %>

		<!-- 다음 -->
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
	</div>

	<!-- 검색창 -->
	<div class="row center">
		<form action="list.jsp" method="get">

			<select name="column" class="form-input form-inline">
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

			<input type="search" name="keyword" placeholder="검색어 입력" required 
					value="<%=pagination.getKeywordString()%>" class="form-input form-inline" autocomplete="off">

			<input type="submit" value="검색" class="form-btn form-inline">

		</form>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>