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
%>

<%
	//페이지 계산 코드
	int psize = 10;
	int p;
	try{
		//Plan A : p라는 파라미터에서 전달되는 값을 숫자로 변환하여 대입 
		p = Integer.parseInt(request.getParameter("p"));
		//강제 예외 : p가 0이하면 문제가 발생한 것으로 간주
		if(p <= 0) {
			throw new Exception();
		}
	}
	catch(Exception e){
		//Plan B : Plan A에서 문제가 발생한 경우 1로 설정
		p = 1;
	}
	
	//begin, end를 계산
	int end = p * psize;
	int begin = end - (psize-1);
%>
p = <%=p%>, begin = <%=begin%>, end = <%=end%>

<%
	//네비게이터 계산 코드
	int bsize = 10;//한 페이지에 표시할 block 개수
	
	BoardDao boardDao = new BoardDao();
	
	//상황별 총 게시글 수를 계산
	int count;
	if(search) {
		count = boardDao.count(column, keyword);
	}
	else{
		count = boardDao.count();
	}
	
	//마지막 블록 번호를 계산
	int lastBlock = (count - 1) / bsize + 1;
	
	int startBlock = (p - 1) / bsize * bsize + 1;
	int finishBlock = startBlock + (bsize - 1);
%>
<br>
startBlock = <%=startBlock%> , finishBlock = <%=finishBlock%>, count = <%=count%>,
lastBlock = <%=lastBlock%>

<%
	List<BoardDto> list;
	if(search){ 
		//list = boardDao.search(column, keyword);//모든검색결과
		list = boardDao.searchByRownum(column, keyword, begin, end);//원하는 검색결과 구간
	}
	else{
		//list = boardDao.list();//모든목록
		list = boardDao.listByRownum(begin, end);//원하는 구간 목록
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
			<td align="left">
				<a href="detail.jsp?boardNo=<%=boardDto.getBoardNo()%>"><%=boardDto.getBoardTitle()%></a>
			</td>
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
<%if(startBlock > 1){ %>
	<%if(search){ %>
		<!-- 검색용 링크 -->
		<a href="list.jsp?column=<%=column%>&keyword=<%=keyword%>&p=<%=startBlock-1%>">&lt;</a>
	<%} else { %>
		<!-- 목록용 링크 -->
		<a href="list.jsp?p=<%=startBlock-1%>">&lt;</a>
	<%} %>
<%} else { %>
	 <a>[이전]</a>
<%} %> 

<%for(int i = startBlock; i <= Math.min(finishBlock, lastBlock); i++){ %>
	<%if(search){ %>
	<!-- 검색용 링크 -->
	<a href="list.jsp?column=<%=column%>&keyword=<%=keyword%>&p=<%=i%>"><%=i%></a>
	<%}else{ %>
	<!-- 목록용 링크 -->
	<a href="list.jsp?p=<%=i%>"><%=i%></a>
	<%} %>
<%} %>

<%if(finishBlock < lastBlock){ %>
	<%if(search){ %>
		<!-- 검색용 링크 -->
		<a href="list.jsp?column=<%=column%>&keyword=<%=keyword%>&p=<%=finishBlock+1%>">&gt;</a>
	<%} else { %>
		<!-- 목록용 링크 -->
		<a href="list.jsp?p=<%=finishBlock+1%>">&gt;</a>
	<%} %> 
<%} else {%>
	<a>[다음]</a>
<%} %>

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