<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 없음 --%>    

<%-- 처리 : List<CoinDto> --%>
<%
	BoardDao boardDao = new BoardDao();
	List<BoardDto> list = boardDao.list();
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>게시글 목록 및 조회</h2>

<table border="1" width="500">
	<thead>
		<tr>
			<th>작성번호</th>		
			<th>작성제목</th>
			<th>작성자</th>
<!-- 			<th>작성내용</th> -->
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody align="center">
		<%for(BoardDto boardDto : list){ %>
		<tr>
			<td><%=boardDto.getBoardNo()%></td>
			<td><a href="./detail.jsp?boardNo=<%=boardDto.getBoardNo()%>"><%=boardDto.getBoardTitle()%></a></td>
			<td><%=boardDto.getBoardWriter()%></td>
<%-- 			<td><%=boardDto.getBoardContent()%></td> --%>
			<td ><%=boardDto.getBoardTime()%></td>			
			<td >조회수</td>	
		</tr>
		<%} %>
	</tbody>
		<tfoot>
		<tr>
			<td colspan="5" align="center">
				<a href="write.jsp">작성</a>
			</td>
		</tr>
	</tfoot>
</table>

<jsp:include page="/template/footer.jsp"></jsp:include>